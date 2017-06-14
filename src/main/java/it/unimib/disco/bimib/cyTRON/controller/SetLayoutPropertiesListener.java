package it.unimib.disco.bimib.cyTRON.controller;

import java.awt.Color;
import java.awt.Paint;
import java.util.Collection;
import java.util.TreeMap;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.events.NetworkAddedEvent;
import org.cytoscape.model.events.NetworkAddedListener;
import org.cytoscape.view.layout.CyLayoutAlgorithm;
import org.cytoscape.view.layout.CyLayoutAlgorithmManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.property.ArrowShapeVisualProperty;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.presentation.property.LineTypeVisualProperty;
import org.cytoscape.view.presentation.property.NodeShapeVisualProperty;
import org.cytoscape.view.presentation.property.values.ArrowShape;
import org.cytoscape.view.presentation.property.values.LineType;
import org.cytoscape.view.presentation.property.values.NodeShape;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.mappings.DiscreteMapping;
import org.cytoscape.view.vizmap.mappings.PassthroughMapping;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskManager;

public class SetLayoutPropertiesListener implements NetworkAddedListener {

    private final CyNetworkViewManager networkViewManager;
    private final CyNetworkViewFactory networkViewFactory;
    private final CyLayoutAlgorithmManager layoutAlgorithmManager;
    private final TaskManager taskManager;
    private final VisualStyleFactory visualStyleFactory;
    private final VisualMappingManager visualMappingManager;
    private final VisualMappingFunctionFactory visualMappingFunctionFactoryDiscrete;
    private final VisualMappingFunctionFactory visualMappingFunctionFactoryPassthrough;

    public SetLayoutPropertiesListener(CyNetworkViewManager networkViewManager, CyNetworkViewFactory networkViewFactory, CyLayoutAlgorithmManager layoutAlgorithmManager,
            TaskManager taskManager, VisualStyleFactory visualStyleFactory, VisualMappingManager visualMappingManager, VisualMappingFunctionFactory visualMappingFunctionFactoryDiscrete,
            VisualMappingFunctionFactory visualMappingFunctionFactoryPassthrough) {
        super();
        
        this.networkViewManager = networkViewManager;
        this.networkViewFactory = networkViewFactory;
        this.layoutAlgorithmManager = layoutAlgorithmManager;
        this.taskManager = taskManager;
        this.visualStyleFactory = visualStyleFactory;
        this.visualMappingManager = visualMappingManager;
        this.visualMappingFunctionFactoryDiscrete = visualMappingFunctionFactoryDiscrete;
        this.visualMappingFunctionFactoryPassthrough = visualMappingFunctionFactoryPassthrough;
    }

    @Override
    public void handleEvent(NetworkAddedEvent arg0) {
        // Get the network and its view
    	CyNetwork network = arg0.getNetwork();
    	CyNetworkView view = null;
    	
    	final Collection<CyNetworkView> views = this.networkViewManager.getNetworkViews(network);
        if (!views.isEmpty()) {
            view = views.iterator().next();
        }
        if (view == null) {
            view = this.networkViewFactory.createNetworkView(network);
            this.networkViewManager.addNetworkView(view);
        }
        
        // Set general layout
        CyLayoutAlgorithm layout = this.layoutAlgorithmManager.getLayout("hierarchic");
        if (layout == null) {
            layout = this.layoutAlgorithmManager.getDefaultLayout();
        }
        TaskIterator taskIterator = layout.createTaskIterator(view, layout.getDefaultLayoutContext(), CyLayoutAlgorithm.ALL_NODE_VIEWS, null);
        this.taskManager.execute(taskIterator);

        // Set node shape
        DiscreteMapping<String, NodeShape> shapeMapping = (DiscreteMapping<String, NodeShape>) this.visualMappingFunctionFactoryDiscrete.createVisualMappingFunction("shape", String.class, BasicVisualLexicon.NODE_SHAPE);
        shapeMapping.putMapValue("ellipse", NodeShapeVisualProperty.ELLIPSE);
        shapeMapping.putMapValue("diamond", NodeShapeVisualProperty.DIAMOND);
        shapeMapping.putMapValue("hexagon", NodeShapeVisualProperty.HEXAGON);
        shapeMapping.putMapValue("octagon", NodeShapeVisualProperty.OCTAGON);
        shapeMapping.putMapValue("parallelogram", NodeShapeVisualProperty.PARALLELOGRAM);
        shapeMapping.putMapValue("Rectangle", NodeShapeVisualProperty.RECTANGLE);
        shapeMapping.putMapValue("round rectangle", NodeShapeVisualProperty.ROUND_RECTANGLE);
        shapeMapping.putMapValue("triangle", NodeShapeVisualProperty.TRIANGLE);
        
        // Set graph visualization rules based on its attributes
        VisualStyle visualStyle = this.visualStyleFactory.createVisualStyle("StyleSet");
        visualStyle.addVisualMappingFunction(shapeMapping);
        
        // Set nodes color
        PassthroughMapping colorMapping = (PassthroughMapping) this.visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("fillcolor", Color.class, BasicVisualLexicon.NODE_FILL_COLOR);
        visualStyle.addVisualMappingFunction(colorMapping);

        // Set nodes label
        PassthroughMapping labelMapping = (PassthroughMapping) this.visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("label", String.class, BasicVisualLexicon.NODE_LABEL);
        visualStyle.addVisualMappingFunction(labelMapping);
        
        // Set nodes label color
        PassthroughMapping fontColorMapping = (PassthroughMapping) this.visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("fontcolor", Color.class, BasicVisualLexicon.NODE_LABEL_COLOR);
        visualStyle.addVisualMappingFunction(fontColorMapping);

        // Set nodes border color
        PassthroughMapping borderColorMapping = (PassthroughMapping) this.visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("bordercolor", Paint.class, BasicVisualLexicon.NODE_BORDER_PAINT);
        visualStyle.addVisualMappingFunction(borderColorMapping);
        
        // Set node border width
        PassthroughMapping borderWidthMapping = (PassthroughMapping) this.visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("borderwidth", Double.class, BasicVisualLexicon.NODE_BORDER_WIDTH);
        visualStyle.addVisualMappingFunction(borderWidthMapping);
        
        // Find the longest label
        int maximumLabelLength = 0;
        CyTable table = network.getDefaultNodeTable();
        for (View<CyNode> nodeView : view.getNodeViews()) {
        	CyRow row = table.getRow(nodeView.getModel().getSUID());
        	
        	String label = row.get("label", String.class);
        	if (label != null && label.length() > maximumLabelLength) {
				maximumLabelLength = label.length(); 
			}
        }
        
        // Set node size
        int nodeWidth = maximumLabelLength * 8;
        for (View<CyNode> nodeView : view.getNodeViews()) {
        	CyRow row = table.getRow(nodeView.getModel().getSUID());
        	if (row.get("label", String.class) != null) {
				nodeView.setLockedValue(BasicVisualLexicon.NODE_WIDTH, Double.valueOf(nodeWidth));
	        	nodeView.setLockedValue(BasicVisualLexicon.NODE_HEIGHT, Double.valueOf(nodeWidth/2));	
			} else {
				nodeView.setLockedValue(BasicVisualLexicon.NODE_WIDTH, Double.valueOf(nodeWidth/2));
	        	nodeView.setLockedValue(BasicVisualLexicon.NODE_HEIGHT, Double.valueOf(nodeWidth/2));
			}
		}
        
        // Nodes ordered by Y and X location
    	TreeMap<Double, TreeMap<Double, View<CyNode>>> orderedNodes = new TreeMap<>();
    	for (View<CyNode> nodeView : view.getNodeViews()) {
    		double y = nodeView.getVisualProperty(BasicVisualLexicon.NODE_Y_LOCATION).doubleValue();
    		double x = nodeView.getVisualProperty(BasicVisualLexicon.NODE_X_LOCATION).doubleValue();
    		if (!orderedNodes.containsKey(y)) {
				orderedNodes.put(y, new TreeMap<>());
			}
    		orderedNodes.get(y).put(x, nodeView);
    	}
    	
    	// Y and X offset
    	double yOffset = nodeWidth/6;
    	double xOffset = (double) nodeWidth/1.5;
    	
    	// Adjust nodes Y and X locations
    	int yLevel = 1;
    	for (TreeMap<Double, View<CyNode>> nodesLevel: orderedNodes.values()) {
    		int halfLevelSize = (int) Math.ceil((double) nodesLevel.size() / 2);
    		
    		int xLevel = 1;
    		for (View<CyNode> nodeView : nodesLevel.values()) {
    			nodeView.setVisualProperty(BasicVisualLexicon.NODE_Y_LOCATION, nodeView.getVisualProperty(BasicVisualLexicon.NODE_Y_LOCATION).doubleValue() + yOffset * yLevel);
    			if (nodesLevel.size() % 2 == 0) {
    				nodeView.setVisualProperty(BasicVisualLexicon.NODE_X_LOCATION, nodeView.getVisualProperty(BasicVisualLexicon.NODE_X_LOCATION).doubleValue() + xOffset * (xLevel - halfLevelSize - 1));
    			} else {
        			nodeView.setVisualProperty(BasicVisualLexicon.NODE_X_LOCATION, nodeView.getVisualProperty(BasicVisualLexicon.NODE_X_LOCATION).doubleValue() + xOffset * (xLevel - halfLevelSize));
    			}
				xLevel++;
    		}
    		yLevel++;
		}

        // Set edges arrow
        DiscreteMapping<String, ArrowShape> arrowMapping = (DiscreteMapping<String, ArrowShape>) this.visualMappingFunctionFactoryDiscrete.createVisualMappingFunction("arrow", String.class, BasicVisualLexicon.EDGE_TARGET_ARROW_SHAPE);
        arrowMapping.putMapValue("True", ArrowShapeVisualProperty.ARROW);
        arrowMapping.putMapValue("False", ArrowShapeVisualProperty.NONE);
        visualStyle.addVisualMappingFunction(arrowMapping);

        // Set edges color
        PassthroughMapping edgeColorMapping = (PassthroughMapping) this.visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("color", Color.class, BasicVisualLexicon.EDGE_STROKE_UNSELECTED_PAINT);
        visualStyle.addVisualMappingFunction(edgeColorMapping);
        
        // Set edges label
        PassthroughMapping edgeLabelMapping = (PassthroughMapping) this.visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("edgelabel", String.class, BasicVisualLexicon.EDGE_LABEL);
        visualStyle.addVisualMappingFunction(edgeLabelMapping);

        // Set edges label color
        PassthroughMapping edgeFontColorMapping = (PassthroughMapping) this.visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("fontColor", Color.class, BasicVisualLexicon.EDGE_LABEL_COLOR);
        visualStyle.addVisualMappingFunction(edgeFontColorMapping);

        // Set edges thickness
        PassthroughMapping edgeThicknessMapping = (PassthroughMapping) this.visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("width", Double.class, BasicVisualLexicon.EDGE_WIDTH);
        visualStyle.addVisualMappingFunction(edgeThicknessMapping);

        // Set edges line type
        DiscreteMapping<String, LineType> edgeLineTypeMapping = (DiscreteMapping<String, LineType>) this.visualMappingFunctionFactoryDiscrete.createVisualMappingFunction("line", String.class, BasicVisualLexicon.EDGE_LINE_TYPE);
        edgeLineTypeMapping.putMapValue("Dash", LineTypeVisualProperty.EQUAL_DASH);
        edgeLineTypeMapping.putMapValue("Solid", LineTypeVisualProperty.SOLID);
        visualStyle.addVisualMappingFunction(edgeLineTypeMapping);
        
        // Apply the visual style
        this.visualMappingManager.addVisualStyle(visualStyle);
        
        visualMappingManager.setVisualStyle(visualStyle, view);
        
    }
}

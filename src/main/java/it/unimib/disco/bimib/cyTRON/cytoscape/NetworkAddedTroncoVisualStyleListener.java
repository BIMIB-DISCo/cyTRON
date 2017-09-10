package it.unimib.disco.bimib.cyTRON.cytoscape;

import java.awt.Color;
import java.awt.Paint;
import java.util.Map;

import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.events.NetworkAddedEvent;
import org.cytoscape.model.events.NetworkAddedListener;
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
import org.cytoscape.view.vizmap.VisualPropertyDependency;
import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.mappings.DiscreteMapping;
import org.cytoscape.view.vizmap.mappings.PassthroughMapping;

public class NetworkAddedTroncoVisualStyleListener implements NetworkAddedListener {

    private final CyNetworkViewManager networkViewManager;
    private final CyNetworkViewFactory networkViewFactory;
    private final VisualStyleFactory visualStyleFactory;
    private final VisualMappingManager visualMappingManager;
    private final VisualMappingFunctionFactory visualMappingFunctionFactoryDiscrete;
    private final VisualMappingFunctionFactory visualMappingFunctionFactoryPassthrough;

    public NetworkAddedTroncoVisualStyleListener(CyNetworkViewManager networkViewManager, CyNetworkViewFactory networkViewFactory,
            VisualStyleFactory visualStyleFactory, VisualMappingManager visualMappingManager, VisualMappingFunctionFactory visualMappingFunctionFactoryDiscrete,
            VisualMappingFunctionFactory visualMappingFunctionFactoryPassthrough) {
        super();
        
        this.networkViewManager = networkViewManager;
        this.networkViewFactory = networkViewFactory;
        this.visualStyleFactory = visualStyleFactory;
        this.visualMappingManager = visualMappingManager;
        this.visualMappingFunctionFactoryDiscrete = visualMappingFunctionFactoryDiscrete;
        this.visualMappingFunctionFactoryPassthrough = visualMappingFunctionFactoryPassthrough;
    }

    @Override
    public void handleEvent(NetworkAddedEvent arg0) {
    	// get the network and its view
    	CyNetwork network = arg0.getNetwork();
    	CyNetworkView view = networkViewFactory.createNetworkView(network);
        networkViewManager.addNetworkView(view, true);

        // get the visual style
        VisualStyle visualStyle = null;
        for (VisualStyle tempVisualStyle : visualMappingManager.getAllVisualStyles()) {
			if (tempVisualStyle.getTitle().equals("TRONCO")) {
				visualStyle = tempVisualStyle;
				break;
			}
		}
        
        // create the visual style if it is the first added network
        if (visualStyle == null) {
        	visualStyle = visualStyleFactory.createVisualStyle("TRONCO");
		
	        // remove the lock of nodes' height-width and set the arrow color
	        for (VisualPropertyDependency visualPropertyDependency : visualStyle.getAllVisualPropertyDependencies()) {
				if (visualPropertyDependency.getIdString().equals("nodeSizeLocked")) {
					visualPropertyDependency.setDependency(false);
				} else if (visualPropertyDependency.getIdString().equals("arrowColorMatchesEdge")) {
					visualPropertyDependency.setDependency(true);
				}
	        }
	        
	        // set node width
	        PassthroughMapping widthMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("width", Color.class, BasicVisualLexicon.NODE_WIDTH);
	        visualStyle.addVisualMappingFunction(widthMapping);
	        
	        // set node height
	        PassthroughMapping heightMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("height", Color.class, BasicVisualLexicon.NODE_HEIGHT);
	        visualStyle.addVisualMappingFunction(heightMapping);
	        
	        // set node shape
	        DiscreteMapping<String, NodeShape> shapeMapping = (DiscreteMapping<String, NodeShape>) visualMappingFunctionFactoryDiscrete.createVisualMappingFunction("shape", String.class, BasicVisualLexicon.NODE_SHAPE);
	        shapeMapping.putMapValue("ellipse", NodeShapeVisualProperty.ELLIPSE);
	        shapeMapping.putMapValue("diamond", NodeShapeVisualProperty.DIAMOND);
	        shapeMapping.putMapValue("hexagon", NodeShapeVisualProperty.HEXAGON);
	        shapeMapping.putMapValue("octagon", NodeShapeVisualProperty.OCTAGON);
	        shapeMapping.putMapValue("parallelogram", NodeShapeVisualProperty.PARALLELOGRAM);
	        shapeMapping.putMapValue("rectangle", NodeShapeVisualProperty.RECTANGLE);
	        shapeMapping.putMapValue("round rectangle", NodeShapeVisualProperty.ROUND_RECTANGLE);
	        shapeMapping.putMapValue("triangle", NodeShapeVisualProperty.TRIANGLE);
	        visualStyle.addVisualMappingFunction(shapeMapping);
	        
	        // set nodes color
	        PassthroughMapping colorMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("fillcolor", Color.class, BasicVisualLexicon.NODE_FILL_COLOR);
	        visualStyle.addVisualMappingFunction(colorMapping);
	
	        // set nodes label
	        PassthroughMapping labelMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("label", String.class, BasicVisualLexicon.NODE_LABEL);
	        visualStyle.addVisualMappingFunction(labelMapping);
	        
	        // set nodes label color
	        PassthroughMapping fontColorMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("fontcolor", Color.class, BasicVisualLexicon.NODE_LABEL_COLOR);
	        visualStyle.addVisualMappingFunction(fontColorMapping);
	
	        // set nodes border color
	        PassthroughMapping borderColorMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("bordercolor", Paint.class, BasicVisualLexicon.NODE_BORDER_PAINT);
	        visualStyle.addVisualMappingFunction(borderColorMapping);
	        
	        // set node border width
	        PassthroughMapping borderWidthMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("borderwidth", Double.class, BasicVisualLexicon.NODE_BORDER_WIDTH);
	        visualStyle.addVisualMappingFunction(borderWidthMapping);
	
	        // set edges arrow
	        DiscreteMapping<String, ArrowShape> arrowMapping = (DiscreteMapping<String, ArrowShape>) visualMappingFunctionFactoryDiscrete.createVisualMappingFunction("arrow", String.class, BasicVisualLexicon.EDGE_TARGET_ARROW_SHAPE);
	        arrowMapping.putMapValue("True", ArrowShapeVisualProperty.ARROW);
	        arrowMapping.putMapValue("False", ArrowShapeVisualProperty.NONE);
	        visualStyle.addVisualMappingFunction(arrowMapping);
	
	        // set edges color
	        PassthroughMapping edgeColorMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("color", Color.class, BasicVisualLexicon.EDGE_UNSELECTED_PAINT);
	        visualStyle.addVisualMappingFunction(edgeColorMapping);
	        
	        // set edges label
	        PassthroughMapping edgeLabelMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("edgelabel", String.class, BasicVisualLexicon.EDGE_LABEL);
	        visualStyle.addVisualMappingFunction(edgeLabelMapping);
	
	        // set edges label color
	        PassthroughMapping edgeFontColorMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("labelcolor", Color.class, BasicVisualLexicon.EDGE_LABEL_COLOR);
	        visualStyle.addVisualMappingFunction(edgeFontColorMapping);
	
	        // set edges thickness
	        PassthroughMapping edgeThicknessMapping = (PassthroughMapping) visualMappingFunctionFactoryPassthrough.createVisualMappingFunction("width", Double.class, BasicVisualLexicon.EDGE_WIDTH);
	        visualStyle.addVisualMappingFunction(edgeThicknessMapping);
	
	        // set edges line type
	        DiscreteMapping<String, LineType> edgeLineTypeMapping = (DiscreteMapping<String, LineType>) visualMappingFunctionFactoryDiscrete.createVisualMappingFunction("line", String.class, BasicVisualLexicon.EDGE_LINE_TYPE);
	        edgeLineTypeMapping.putMapValue("dash", LineTypeVisualProperty.EQUAL_DASH);
	        edgeLineTypeMapping.putMapValue("solid", LineTypeVisualProperty.SOLID);
	        visualStyle.addVisualMappingFunction(edgeLineTypeMapping);
        
        }
        
        // get the rescaling factor
        Double currentScaleMaximum = 50d;
        Double maximumSize = 0d;
        CyTable table = network.getDefaultNodeTable();
        for (View<CyNode> nodeView : view.getNodeViews()) {
        	Map<String, Object> rowValues = table.getRow(nodeView.getModel().getSUID()).getAllValues();
        	
        	Double width = (Double) rowValues.get("width");
        	if (width != null && width > maximumSize) {
				maximumSize = width;
			}
        	
        	Double height = (Double) rowValues.get("height");
        	if (height != null && height > maximumSize) {
				maximumSize = height;
			}
        }
        final Double rescalingFactor = maximumSize/currentScaleMaximum;
        
        // set the new size
        for (View<CyNode> nodeView : view.getNodeViews()) {
        	CyRow row = table.getRow(nodeView.getModel().getSUID());
        	Map<String, Object> rowValues = row.getAllValues();
        	
        	Double width = (Double) rowValues.get("width");
        	row.set("width", width/rescalingFactor);
        	
        	Double height = (Double) rowValues.get("height");
        	row.set("height", height/rescalingFactor);
        }
        
        // correct the triple / in the label
        CyTable edgeTable = network.getDefaultEdgeTable();
        for (View<CyEdge> edgeView : view.getEdgeViews()) {
        	CyRow row = edgeTable.getRow(edgeView.getModel().getSUID());
        	Map<String, Object> rowValues = row.getAllValues();
        	
        	String label = (String) rowValues.get("edgelabel");
        	if (label != null) {
        		row.set("edgelabel", label.replace("\\", ""));
			}        	
        }
        
        // apply the visual style
        visualMappingManager.setVisualStyle(visualStyle, view);
    }
}

package org.cytoscape.cytron.cyTRON;


import java.awt.Color;
import java.awt.Paint;
import java.util.Collection;


import org.cytoscape.model.CyIdentifiable;
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
	
	
	private CyNetworkViewManager networkViewManager;
	private CyNetworkViewFactory networkViewFactory;
	private CyLayoutAlgorithmManager layoutAlgorithmManager;
	private TaskManager taskManager;
	private VisualStyleFactory visualStyleFactory;
	private VisualMappingManager visualMappingManager;
	private VisualMappingFunctionFactory vmfFactoryD;
	private VisualMappingFunctionFactory vmfFactoryP;
	
	
	
	public SetLayoutPropertiesListener(CyNetworkViewManager networkViewManager, 
			CyNetworkViewFactory networkViewFactory,
			CyLayoutAlgorithmManager layoutAlgorithmManager, 
			TaskManager taskManager,
			VisualStyleFactory visualStyleFactory, 
			VisualMappingManager visualMappingManager,
			VisualMappingFunctionFactory vmfFactoryD, 
			VisualMappingFunctionFactory vmfFactoryP) {
		super();
		this.networkViewManager = networkViewManager;
		this.networkViewFactory = networkViewFactory;
		this.layoutAlgorithmManager = layoutAlgorithmManager;
		this.taskManager = taskManager;
		this.visualStyleFactory = visualStyleFactory;
		this.visualMappingManager = visualMappingManager;
		this.vmfFactoryD = vmfFactoryD;
		this.vmfFactoryP = vmfFactoryP;
	}
	
	@Override
	public void handleEvent(NetworkAddedEvent arg0) {
		CyNetwork net = arg0.getNetwork();
		final Collection<CyNetworkView> views = networkViewManager.getNetworkViews(net);
		
		CyNetworkView view = null;
		CyTable table = net.getDefaultNodeTable();
		if (views.size() != 0)
			view = views.iterator().next();
		if (view == null) {
			// create a new view for my network
			view = networkViewFactory.createNetworkView(net);
			networkViewManager.addNetworkView(view);
		} else {
			System.out.println("networkView already existed.");
		}
		
		
		CyLayoutAlgorithm layout = layoutAlgorithmManager.getLayout("yFiles.hierarchic");
		for(CyLayoutAlgorithm ciao : layoutAlgorithmManager.getAllLayouts())
			System.out.println(ciao.getName());
		if (layout == null)
			layout = layoutAlgorithmManager.getDefaultLayout();
		// cambio layout a tutti i nodi;
		TaskIterator taskIterator = layout.createTaskIterator(view, layout.getDefaultLayoutContext(),
				CyLayoutAlgorithm.ALL_NODE_VIEWS, null);
		taskManager.execute(taskIterator);
		
		VisualStyle vs = visualStyleFactory.createVisualStyle("StyleSet");
		
		visualMappingManager.addVisualStyle(vs);
		
		DiscreteMapping d = (DiscreteMapping) vmfFactoryD.createVisualMappingFunction("shape", 
				String.class, BasicVisualLexicon.NODE_SHAPE);
		
		
		d.putMapValue("ellipse", NodeShapeVisualProperty.ELLIPSE);
		d.putMapValue("diamond", NodeShapeVisualProperty.DIAMOND);
		d.putMapValue("hexagon", NodeShapeVisualProperty.HEXAGON);
		d.putMapValue("octagon", NodeShapeVisualProperty.OCTAGON);
		d.putMapValue("parallelogram", NodeShapeVisualProperty.PARALLELOGRAM);
		d.putMapValue("Rectangle", NodeShapeVisualProperty.RECTANGLE);
		d.putMapValue("round rectangle", NodeShapeVisualProperty.ROUND_RECTANGLE);
		d.putMapValue("triangle", NodeShapeVisualProperty.TRIANGLE);
		
		vs.addVisualMappingFunction(d);
		
		PassthroughMapping p = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("fillcolor", 
				Color.class, BasicVisualLexicon.NODE_FILL_COLOR);
		
		vs.addVisualMappingFunction(p);
		
		PassthroughMapping p_label = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("label", 
				String.class, BasicVisualLexicon.NODE_LABEL);
		
		vs.addVisualMappingFunction(p_label);
		
		PassthroughMapping p_fontColor = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("fontcolor", 
				Color.class, BasicVisualLexicon.NODE_LABEL_COLOR);
		
		vs.addVisualMappingFunction(p_fontColor);
		
		PassthroughMapping p_borderColor = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("bordercolor", 
				Paint.class, BasicVisualLexicon.NODE_BORDER_PAINT);
		
		vs.addVisualMappingFunction(p_borderColor);
		
		PassthroughMapping p_width = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("width", 
				Double.class, BasicVisualLexicon.NODE_WIDTH);
		
		vs.addVisualMappingFunction(p_width);
		
		PassthroughMapping p_height = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("height", 
				Double.class, BasicVisualLexicon.NODE_HEIGHT);
		
		vs.addVisualMappingFunction(p_height);
		
		PassthroughMapping p_borderwidth = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("borderwidth", 
				Double.class, BasicVisualLexicon.NODE_BORDER_WIDTH);
		
		vs.addVisualMappingFunction(p_borderwidth);
		
		DiscreteMapping d_arrow = (DiscreteMapping) vmfFactoryD.createVisualMappingFunction("arrow", 
				String.class, BasicVisualLexicon.EDGE_TARGET_ARROW_SHAPE);
		
		d_arrow.putMapValue("True", ArrowShapeVisualProperty.ARROW);
		d_arrow.putMapValue("False", ArrowShapeVisualProperty.NONE);
		
		vs.addVisualMappingFunction(d_arrow);
		
		PassthroughMapping p_edgeColor = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("color", 
				Color.class, BasicVisualLexicon.EDGE_STROKE_UNSELECTED_PAINT);
		
		vs.addVisualMappingFunction(p_edgeColor);
		
		
		
		PassthroughMapping p_edgeFontColor = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("fontColor", 
				Color.class, BasicVisualLexicon.EDGE_LABEL_COLOR);
		
		vs.addVisualMappingFunction(p_edgeFontColor);
		
		PassthroughMapping p_edgeLabel = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("label2", 
				String.class, BasicVisualLexicon.EDGE_LABEL);
		
		vs.addVisualMappingFunction(p_edgeLabel);
		
		PassthroughMapping p_edgeThick = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction("thickness", 
				Double.class, BasicVisualLexicon.EDGE_WIDTH);
		
		vs.addVisualMappingFunction(p_edgeThick);
		
		
		DiscreteMapping d_edge = (DiscreteMapping) vmfFactoryD.createVisualMappingFunction("line", 
				String.class, BasicVisualLexicon.EDGE_LINE_TYPE);
		
		d_edge.putMapValue("Dash", LineTypeVisualProperty.EQUAL_DASH);
		d_edge.putMapValue("Solid", LineTypeVisualProperty.SOLID);
		
		vs.addVisualMappingFunction(d_edge);
		
		vs.apply(view);
				
		for(View<CyNode> v : view.getNodeViews()){
			CyRow row = table.getRow(v.getModel().getSUID());
			
			if(row.get("width", Double.class, "20") != null){
								v.setLockedValue(BasicVisualLexicon.NODE_WIDTH, 
						(Double) row.get("width", Double.class, 20));
			}
			if(row.get("height", Double.class, "20") != null){
				v.setLockedValue(BasicVisualLexicon.NODE_HEIGHT, 
						(Double) row.get("height", Double.class, 20));
			}
			 
			 
		}
		
	}
	private static NodeShape getShape(String arg) {
		switch (arg) {
		default:
			return NodeShapeVisualProperty.DIAMOND;
		case "DIAMOND":
			return NodeShapeVisualProperty.DIAMOND;
		case "ELLIPSE":
			return NodeShapeVisualProperty.ELLIPSE;
		case "HEXAGON":
			return NodeShapeVisualProperty.HEXAGON;
		case "OCATAGON":
			return NodeShapeVisualProperty.OCTAGON;
		case "PARALLELOGRAM":
			return NodeShapeVisualProperty.PARALLELOGRAM;
		case "RECTANGLE":
			return NodeShapeVisualProperty.RECTANGLE;
		case "ROUND_RECTANGLE":
			return NodeShapeVisualProperty.ROUND_RECTANGLE;
		case "TRIANGLE":
			return NodeShapeVisualProperty.TRIANGLE;
		}
	}

}

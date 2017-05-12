package it.unimib.disco.bimib.cyTRON;

import java.awt.Color;
import java.awt.Paint;
import java.util.Collection;

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

    private final CyNetworkViewManager networkViewManager;
    private final CyNetworkViewFactory networkViewFactory;
    private final CyLayoutAlgorithmManager layoutAlgorithmManager;
    private final TaskManager taskManager;
    private final VisualStyleFactory visualStyleFactory;
    private final VisualMappingManager visualMappingManager;
    private final VisualMappingFunctionFactory vmfFactoryD;
    private final VisualMappingFunctionFactory vmfFactoryP;

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
        final Collection<CyNetworkView> views
                = networkViewManager.getNetworkViews(net);

        CyNetworkView view = null;
        CyTable table = net.getDefaultNodeTable();
        if (!views.isEmpty()) {
            view = views.iterator().next();
        }
        if (view == null) {
            view = networkViewFactory.createNetworkView(net);
            networkViewManager.addNetworkView(view);
        }
        
        // Layout retrieval
        CyLayoutAlgorithm layout = layoutAlgorithmManager.getLayout("hierarchic");
        if (layout == null) {
            layout = layoutAlgorithmManager.getDefaultLayout();
        }
        
        // Set layout for all nodes
        TaskIterator taskIterator = layout.createTaskIterator(view,
                layout.getDefaultLayoutContext(),
                CyLayoutAlgorithm.ALL_NODE_VIEWS, null);
        taskManager.execute(taskIterator);

        
        // Set graph visualization rules based on its attributes
        VisualStyle vs = visualStyleFactory.createVisualStyle("StyleSet");
        visualMappingManager.addVisualStyle(vs);

        // Set node shape
        DiscreteMapping d
                = (DiscreteMapping) vmfFactoryD.createVisualMappingFunction(
                        "shape",
                        String.class,
                        BasicVisualLexicon.NODE_SHAPE);

        d.putMapValue("ellipse", NodeShapeVisualProperty.ELLIPSE);
        d.putMapValue("diamond", NodeShapeVisualProperty.DIAMOND);
        d.putMapValue("hexagon", NodeShapeVisualProperty.HEXAGON);
        d.putMapValue("octagon", NodeShapeVisualProperty.OCTAGON);
        d.putMapValue("parallelogram", NodeShapeVisualProperty.PARALLELOGRAM);
        d.putMapValue("Rectangle", NodeShapeVisualProperty.RECTANGLE);
        d.putMapValue("round rectangle", NodeShapeVisualProperty.ROUND_RECTANGLE);
        d.putMapValue("triangle", NodeShapeVisualProperty.TRIANGLE);

        vs.addVisualMappingFunction(d);
        
        // Set node color
        PassthroughMapping p
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "fillcolor",
                        Color.class,
                        BasicVisualLexicon.NODE_FILL_COLOR);
        vs.addVisualMappingFunction(p);

        // Set node label
        PassthroughMapping p_label
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "label",
                        String.class,
                        BasicVisualLexicon.NODE_LABEL);
        vs.addVisualMappingFunction(p_label);
        
        // Set node label color
        PassthroughMapping p_fontColor
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "fontcolor",
                        Color.class,
                        BasicVisualLexicon.NODE_LABEL_COLOR);
        vs.addVisualMappingFunction(p_fontColor);

        // Set node border color
        PassthroughMapping p_borderColor
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "bordercolor",
                        Paint.class,
                        BasicVisualLexicon.NODE_BORDER_PAINT);
        vs.addVisualMappingFunction(p_borderColor);
/*
        // Set node width
        PassthroughMapping p_width
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "width",
                        Double.class,
                        BasicVisualLexicon.NODE_WIDTH);
        vs.addVisualMappingFunction(p_width);

        // Set node height
        PassthroughMapping p_height
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "height",
                        Double.class,
                        BasicVisualLexicon.NODE_HEIGHT);
        vs.addVisualMappingFunction(p_height);
*/
        // Set node border width
        PassthroughMapping p_borderwidth
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "borderwidth",
                        Double.class,
                        BasicVisualLexicon.NODE_BORDER_WIDTH);
        vs.addVisualMappingFunction(p_borderwidth);
        
        
        for (View<CyNode> v : view.getNodeViews()) {
            CyRow row = table.getRow(v.getModel().getSUID());

            if (row.get("width", Double.class, "20") != null) {
                v.setLockedValue(BasicVisualLexicon.NODE_WIDTH,
                        (Double) row.get("width", Double.class, 20));
            }
            if (row.get("height", Double.class, "20") != null) {
                v.setLockedValue(BasicVisualLexicon.NODE_HEIGHT,
                        (Double) row.get("height", Double.class, 20));
            }
        }

        // Set edge arrow
        DiscreteMapping d_arrow
                = (DiscreteMapping) vmfFactoryD.createVisualMappingFunction(
                        "arrow",
                        String.class,
                        BasicVisualLexicon.EDGE_TARGET_ARROW_SHAPE);
        
        d_arrow.putMapValue("True", ArrowShapeVisualProperty.ARROW);
        d_arrow.putMapValue("False", ArrowShapeVisualProperty.NONE);

        vs.addVisualMappingFunction(d_arrow);

        // Set edge color
        PassthroughMapping p_edgeColor
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "color",
                        Color.class,
                        BasicVisualLexicon.EDGE_STROKE_UNSELECTED_PAINT);
        vs.addVisualMappingFunction(p_edgeColor);
        
        // Set edge label
        PassthroughMapping p_edgeLabel
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "edgelabel",
                        String.class,
                        BasicVisualLexicon.EDGE_LABEL);
        vs.addVisualMappingFunction(p_edgeLabel);

        // Set edge label color
        PassthroughMapping p_edgeFontColor
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "fontColor",
                        Color.class,
                        BasicVisualLexicon.EDGE_LABEL_COLOR);
        vs.addVisualMappingFunction(p_edgeFontColor);

        // Set edge thickness
        PassthroughMapping p_edgeThick
                = (PassthroughMapping) vmfFactoryP.createVisualMappingFunction(
                        "thickness",
                        Double.class,
                        BasicVisualLexicon.EDGE_WIDTH);
        vs.addVisualMappingFunction(p_edgeThick);

        // Set edge line type
        DiscreteMapping d_edge
                = (DiscreteMapping) vmfFactoryD.createVisualMappingFunction(
                        "line",
                        String.class,
                        BasicVisualLexicon.EDGE_LINE_TYPE);

        d_edge.putMapValue("Dash", LineTypeVisualProperty.EQUAL_DASH);
        d_edge.putMapValue("Solid", LineTypeVisualProperty.SOLID);

        vs.addVisualMappingFunction(d_edge);

        // Apply the visual style to the network
        vs.apply(view);


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

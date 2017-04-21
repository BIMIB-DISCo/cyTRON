package org.cytoscape.cytron.cyTRON.internal;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.cytoscape.app.CyAppAdapter;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.command.AvailableCommands;
import org.cytoscape.command.CommandExecutorTaskFactory;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.SynchronousTaskManager;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.TaskObserver;
import org.cytoscape.work.Tunable;


import org.rosuda.JRI.Rengine;

public class ImportGraphTask extends AbstractTask {

	private CyAppAdapter adapter;
	private CyApplicationManager cyApplicationManagerServiceRef;
	private VisualMappingManager vmmServiceRef;
	private VisualStyleFactory visualStyleFactoryServiceRef;
	private VisualMappingFunctionFactory vmfFactoryC;
	private VisualMappingFunctionFactory vmfFactoryP;
	private CyNetworkViewManager cyNetworkViewManagerServiceRef;
	private CyServiceRegistrar srr ;
	
	CommandExecutorTaskFactory commandTaskFactory = null;
	SynchronousTaskManager taskManager = null;
	AvailableCommands availableCommands = null;

	
	public ImportGraphTask(CyAppAdapter a, 
			CyApplicationManager cyApplicationManagerServiceRef,
			VisualMappingManager vmmServiceRef, 
			VisualStyleFactory visualStyleFactoryServiceRef,
			VisualMappingFunctionFactory vmfFactoryC, 
			VisualMappingFunctionFactory vmfFactoryP) {
		this.adapter = a;
		this.cyApplicationManagerServiceRef = cyApplicationManagerServiceRef;
		this.vmmServiceRef = vmmServiceRef;
		this.visualStyleFactoryServiceRef = visualStyleFactoryServiceRef;
		this.vmfFactoryC = vmfFactoryC;
		this.vmfFactoryP = vmfFactoryP;
		srr = a.getCyServiceRegistrar();

	}

	@Tunable(description = "Network file", params = "fileCategory=network;input=true")
	public File f;
	
	

	public void run(TaskMonitor monitor) {
		
		if (!Rengine.versionCheck()) {
		    System.err.println("** Version mismatch - Java files don't match library version.");
		    System.exit(1);
		}
		
		Rengine re = new Rengine(null, false, new TextConsole());
		
		
		if (!re.waitForR()) {
            System.out.println("Cannot load R");
            return;
        }
		
		re.eval("source('" + f.getAbsolutePath() + "')");
		TaskObserver t = new TaskObserver(){
			@Override
			public void taskFinished(ObservableTask arg0) {
				System.out.println("TaskFinished");
			}
			@Override
			public void allFinished(FinishStatus arg0) {
				System.out.println("TaskAllFinished");
				
			}
		};
		
		HashMap<String, Object> mappa = new HashMap<String, Object>();
		mappa.put("file", f.getAbsolutePath());
		executeCommand("network", "load file", mappa, t);
		
	}
		

		// step 3
		/*
		n.getDefaultNodeTable().getRow(n1.getSUID()).set("name", "Nuovo nome n1");
		n.getDefaultNodeTable().getRow(n2.getSUID()).set("name", "Nuovo nome n2");

		n.getDefaultNodeTable().createListColumn("Hello", String.class, false);
		n.getDefaultNodeTable().createColumn("World", Double.class, false);

		LinkedList<String> s = new LinkedList<String>();
		s.add("ciao");
		s.add("Tutto");
		n.getDefaultNodeTable().getRow(n1.getSUID()).set("Hello", s);
		n.getDefaultNodeTable().getRow(n2.getSUID()).set("Hello", s);
		n.getDefaultNodeTable().getRow(n2.getSUID()).set("World", 10d);
		n.getDefaultNodeTable().getRow(n1.getSUID()).set("World", 12d);
		// step 4

		VisualStyle vs = this.visualStyleFactoryServiceRef.createVisualStyle("Sample Visual Style");
		this.vmmServiceRef.addVisualStyle(vs);

		ContinuousMapping cMapping = (ContinuousMapping) this.vmfFactoryC.createVisualMappingFunction("World",
				Double.class, BasicVisualLexicon.NODE_FILL_COLOR);
		// cMapping.addPoint(arg0, arg1);
		Double val1 = 2d;
		/*
		BoundaryRangeValues<Paint> brv1 = new BoundaryRangeValues<Paint>(Color.RED, Color.GREEN,
				getColor(col1.getSelectedValue()));

		Double val2 = 12d;
		BoundaryRangeValues<Paint> brv2 = new BoundaryRangeValues<Paint>(getColor(col2.getSelectedValue()), Color.YELLOW,
				Color.BLACK);
		

		cMapping.addPoint(val1, brv1);
		cMapping.addPoint(val2, brv2);
		vs.addVisualMappingFunction(cMapping);
	
		CyNetworkViewFactory cnvf = adapter.getCyNetworkViewFactory();
		cyNetworkViewManagerServiceRef = adapter.getCyNetworkViewManager();

		final Collection<CyNetworkView> views = cyNetworkViewManagerServiceRef.getNetworkViews(n);
		CyNetworkView myView = null;
		if (views.size() != 0)
			myView = views.iterator().next();

		if (myView == null) {
			// create a new view for my network
			myView = cnvf.createNetworkView(n);
			cyNetworkViewManagerServiceRef.addNetworkView(myView);
		} else {
			System.out.println("networkView already existed.");
		}
		vs.apply(myView);
		CyLayoutAlgorithmManager layoutManager = adapter.getCyLayoutAlgorithmManager();
		CyLayoutAlgorithm layout = layoutManager.getLayout("grid");
		if (layout == null)
			layout = layoutManager.getDefaultLayout();
		// cambio layout a tutti i nodi;
		TaskIterator taskIterator = layout.createTaskIterator(myView, layout.getDefaultLayoutContext(),
				CyLayoutAlgorithm.ALL_NODE_VIEWS, null);
		adapter.getTaskManager().execute(taskIterator);

		for (View<CyNode> nodeView : myView.getNodeViews()) {

			nodeView.setLockedValue(BasicVisualLexicon.NODE_LABEL,

					n.getDefaultNodeTable().getRow(nodeView.getModel().getSUID()).getList("Hello", String.class)
							.get(0));

			//nodeView.setLockedValue(BasicVisualLexicon.NODE_SHAPE, getShape(shape.getSelectedValue()));
		}

	}
	*/
	public <S> S getService(Class<S> serviceClass) {
		return srr.getService(serviceClass);
	}

	public void executeCommand(String namespace, String command, Map<String, Object> args, TaskObserver observer) {
		if (commandTaskFactory == null)
			commandTaskFactory = getService(CommandExecutorTaskFactory.class);
		if (availableCommands == null)
			availableCommands = getService(AvailableCommands.class);
		if (taskManager == null)
			taskManager = getService(SynchronousTaskManager.class);
		if (!availableCommands.getNamespaces().contains(namespace)
				|| !availableCommands.getCommands(namespace).contains(command))
			throw new RuntimeException("Can’t find command " + namespace + " " + command);
		TaskIterator ti = commandTaskFactory.createTaskIterator(namespace, command, args, observer);
		taskManager.execute(ti);
	}
	


}
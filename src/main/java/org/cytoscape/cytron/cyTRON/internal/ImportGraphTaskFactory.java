package org.cytoscape.cytron.cyTRON.internal;


import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.cytron.cyTRON.internal.ImportGraphTask;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class ImportGraphTaskFactory extends AbstractTaskFactory {

	
	private CyApplicationManager cyApplicationManagerServiceRef;
	private VisualMappingManager vmmServiceRef;
	private VisualStyleFactory visualStyleFactoryServiceRef;
	private VisualMappingFunctionFactory vmfFactoryC;
	private VisualMappingFunctionFactory vmfFactoryP;
	private CyServiceRegistrar registrar;
	
	public ImportGraphTaskFactory(CyApplicationManager cyApplicationManagerServiceRef, VisualMappingManager vmmServiceRef,
			VisualStyleFactory visualStyleFactoryServiceRef, VisualMappingFunctionFactory vmfFactoryC,
			VisualMappingFunctionFactory vmfFactoryP, CyServiceRegistrar registrar){
		
		this.cyApplicationManagerServiceRef = cyApplicationManagerServiceRef;
		this.vmmServiceRef = vmmServiceRef;
		this.visualStyleFactoryServiceRef = visualStyleFactoryServiceRef;
		this.vmfFactoryC = vmfFactoryC;
		this.vmfFactoryP = vmfFactoryP;
		this.registrar = registrar;
	}
	
	
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new ImportGraphTask(cyApplicationManagerServiceRef, vmmServiceRef,
				visualStyleFactoryServiceRef, vmfFactoryC,
				 vmfFactoryP, registrar));
	}
}

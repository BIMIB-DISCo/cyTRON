package it.unimib.disco.bimib.cyTRON.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;

import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskObserver;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.cytoscape.CommandExecutor;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Model;
import it.unimib.disco.bimib.cyTRON.model.Statistics;

public class VisualizationController {
	
	private static final Statistics[] DEFAULT_STATISTICS = new Statistics[]{new Statistics("hg", "hg"), new Statistics("tp", "tp"), new Statistics("pr", "pr")};  
	
	private final CommandExecutor commandExecutor;
	
	private final DefaultListModel<Model> modelsListModel;
	private final DefaultListModel<Statistics> statisticsListModel;
	
	public VisualizationController(CommandExecutor commandExecutor) {
		this.commandExecutor = commandExecutor;
		
		modelsListModel = new DefaultListModel<>();
		statisticsListModel = new DefaultListModel<>();
	}

	public void annotareDescription(Dataset dataset, String description) {
		// annotate the description
		dataset.annotateDescription(description);
	}
	
	public void annotateStages(Dataset dataset, String annotateStagesPath) {
		// validate the path
		annotateStagesPath = annotateStagesPath.replace("\\", "\\\\");
		
		// read the stages
		HashMap<String, String> stages = new HashMap<>();
		try {
			for (String line : Files.readAllLines(Paths.get(annotateStagesPath))) {
				String[] splitLine = line.split("\t");
				stages.put(splitLine[0], splitLine[1]);
			}
		} catch (IOException e) {}
		
		// annotate the stages
		dataset.annotateStages(stages);
	}
	
	public void oncoprint(Dataset dataset, Boolean exclusivitySort, Boolean labelSort, Boolean stageSort, Boolean clusterSamples,
			Boolean clusterGenes, Boolean annotateStage, Boolean annotateHits, Float fontSize, Boolean samplesName, Boolean legend,
			Float legendSize, String samplesGroupPath, Boolean pattern) throws IOException {
		// validate the path
		samplesGroupPath = samplesGroupPath.replace("\\", "\\\\");
		
		// read the groups
		HashMap<String, String> groups = new HashMap<>();
		if (samplesGroupPath.length() > 0) {
			for (String line : Files.readAllLines(Paths.get(samplesGroupPath))) {
				String[] splitLine = line.split("\t");
				groups.put(splitLine[0], splitLine[1]);
			}
		}
		
		// create the temporary pdf file
		File file = File.createTempFile("oncoprint_" + dataset.getName() + "_", ".pdf");
		
		// get the path and delete the file
		String path = file.getAbsolutePath();
		path = path.replace("\\", "\\\\");
		file.delete();
		
		// get the oncoprint of the dataset
		dataset.oncoprint(path, exclusivitySort, labelSort, stageSort, clusterSamples, clusterGenes, annotateStage, annotateHits, fontSize, samplesName, legend, legendSize, groups, pattern);
		
		// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// open the pdf file
			Desktop.getDesktop().open(file);
        }
	}
	
	public void plot(Dataset dataset, List<Model> models, Boolean primaFacie, Boolean disconnectedNodes, Boolean scaleNodes,
			List<Statistics> confidence, Float pvalueCutoff, Boolean expandHypotheses) throws IOException {
		// create the temporary graphml file
		File file = File.createTempFile("plot_" + dataset.getName() + "_", ".graphml");
		
		// get the path and delete the file
		String path = file.getAbsolutePath();
		path = path.replace("\\", "\\\\");
		file.delete();
		
		// create the graphml file
		dataset.plot(path, models, primaFacie, disconnectedNodes, scaleNodes, confidence, pvalueCutoff, expandHypotheses);

        // if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// instantiate the task observer
            TaskObserver taskObserver = new TaskObserver() {
                @Override
                public void taskFinished(ObservableTask arg0) {}

                @Override
                public void allFinished(FinishStatus arg0) {}
            };
            
        	// import the graphml file into Cytoscape
            HashMap<String, Object> args = new HashMap<>();
            args.put("file", path);
            commandExecutor.executeCommand("network", "load file", args, taskObserver);
		}
	}
	
	public void updateModelsList(Dataset dataset) {
		modelsListModel.clear();
		for (Model model : dataset.getInference().getModels()) {
			modelsListModel.addElement(model);
		}
	}
	
	public void updateStatisticsList(Dataset dataset) {
		statisticsListModel.clear();
		for (Statistics statistics : DEFAULT_STATISTICS) {
			statisticsListModel.addElement(statistics);
		}
		for (Statistics statistics : dataset.getInference().getStatistics()) {
			statisticsListModel.addElement(statistics);
		}
	}
	
	public DefaultListModel<Model> getModelsListModel() {
		return modelsListModel;
	}

	public DefaultListModel<Statistics> getStatisticsListModel() {
		return statisticsListModel;
	}
}

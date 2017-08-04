package it.unimib.disco.bimib.cyTRON.controller;

import java.util.List;

import it.unimib.disco.bimib.cyTRON.model.Dataset;

public class InferenceController {

	public static final String CAPRESE = "caprese";
	public static final String CAPRI = "capri";
	public static final String CHOWLIU = "chowliu";
	public static final String EDMONDS = "edmonds";
	public static final String GABOW = "gabow";
	public static final String PRIM = "prim";
	
	public static final String NO_REG = "no_reg";
	
	public static final String[] ALGORITHMS = new String[]{CAPRESE, CAPRI, CHOWLIU, EDMONDS, GABOW, PRIM};
	public static final String[] COMMANDS = new String[]{"hc", "tabu"};
	public static final String[] REGULARIZATIONS = new String[]{"bic", "aic", "aic", "loglik", "bde", "bds", "k2", "mbde", "bdla"};
	public static final String[] SCORES = new String[]{"pmi", "mi", "entropy", "cpmi"};
	
	public void inference(Dataset dataset, Object algorithm, Float lambda, Float falsePositive, Float falseNegative,
			String command, List<String> regularization, Boolean estimateErrorRates, Integer bootstrapSamplings,
			Float pValue, Integer initialBootstrapSeeds, Integer restarts, String score, Boolean raisingCondition) {
		if (algorithm.equals(InferenceController.CAPRESE)) {
			dataset.caprese(lambda, falsePositive, falseNegative);
        } else if (algorithm.equals(InferenceController.CAPRI)) {
        	dataset.capri(command, regularization, estimateErrorRates, bootstrapSamplings, pValue, initialBootstrapSeeds, restarts, falsePositive, falseNegative);
        } else if (algorithm.equals(InferenceController.CHOWLIU)) {
        	dataset.chowliu(regularization, estimateErrorRates, bootstrapSamplings, pValue, initialBootstrapSeeds, falsePositive, falseNegative);
        } else if (algorithm.equals(InferenceController.EDMONDS)) {
        	dataset.edmonds(regularization, score, estimateErrorRates, bootstrapSamplings, pValue, initialBootstrapSeeds, falsePositive, falseNegative);
        } else if (algorithm.equals(InferenceController.GABOW)) {
        	dataset.gabow(regularization, score, estimateErrorRates, bootstrapSamplings, pValue, initialBootstrapSeeds, falsePositive, falseNegative, raisingCondition);
        } else if (algorithm.equals(InferenceController.PRIM)) {
        	dataset.prim(regularization, estimateErrorRates, bootstrapSamplings, pValue, initialBootstrapSeeds, falsePositive, falseNegative);
        }
	}
}

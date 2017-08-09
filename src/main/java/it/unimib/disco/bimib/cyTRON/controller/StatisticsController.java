package it.unimib.disco.bimib.cyTRON.controller;

import it.unimib.disco.bimib.cyTRON.model.Dataset;

public class StatisticsController {
	
	public static final String BOOTSTRAP = "bootstrap";
	public static final String ELOSS = "kfold.eloss";
	public static final String POSTERR = "kfold.posterr";
	public static final String PREDERR = "kfold.prederr";
	
	public static final String NON_PARAMETRIC = "non-parametric";
	public static final String STATISTICAL = "statistical";
	
	public static final String[] STATISTICS = new String[]{BOOTSTRAP, ELOSS, POSTERR, PREDERR};
	public static final String[] TYPES = new String[]{NON_PARAMETRIC, STATISTICAL};
	
	public void statistics(Dataset dataset, Object statistics, String type, Integer bootstrapSamplings,
			Float coresRatio, Integer runs, Integer groups) {
		 if (statistics.equals(StatisticsController.BOOTSTRAP)) {
			 dataset.bootstrap(type, bootstrapSamplings, coresRatio);
		 } else if (statistics.equals(StatisticsController.ELOSS)) {
			 dataset.eloss(runs, groups);
		 } else if (statistics.equals(StatisticsController.POSTERR)) {
			 dataset.posterr(runs, groups, coresRatio);
		 } else if (statistics.equals(StatisticsController.PREDERR)) {
			dataset.prederr(runs, groups, coresRatio);
		}
	}
}

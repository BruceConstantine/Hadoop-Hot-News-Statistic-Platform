package dataAnals;

import dataAnals.clean.DataCleaner;
import dataAnals.jobScheduler.JobShedular;

public class Analysis {
	public static void main(String args[]) throws Exception {
		new DataCleaner().clean();
		new JobShedular().analysis();
	}
}

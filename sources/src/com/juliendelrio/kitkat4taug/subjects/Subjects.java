package com.juliendelrio.kitkat4taug.subjects;

public class Subjects {
	public enum Elements {
		NewSensors, SDCardWithoutPermission, PrintingFramework, NewSMSFramework, FullScreenMode
	}

	public static AbstractSubjectFragment getFragment(Elements element) {
		switch (element) {
		case NewSensors:
			return new SubjectFragmentNewSensors();
		case SDCardWithoutPermission:
			return new SubjectFragmentSDCardWithoutPermission();
		case NewSMSFramework:
			return new SubjectFragmentNewSMSFramework();
		case FullScreenMode:
			return new SubjectFragmentFullScreenMode();
		case PrintingFramework:
			return new SubjectFragmentPrintingFramework();
		default:
			return new AbstractSubjectFragment() {
			};
		}
	}

	public static AbstractSubjectFragment getFragment(String id) {
		return getFragment(Elements.valueOf(id));
	}
}

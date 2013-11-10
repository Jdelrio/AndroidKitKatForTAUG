package com.juliendelrio.kitkat4taug.subjects;

public class Subjects {
	public enum Elements {
		NewSensors, SDCardWithoutPermission, PrintingFramework, NewSMSFramework
	}

	public static AbstractSubjectfFragment getFragment(Elements element) {
		switch (element) {
		case NewSensors:
			return new SubjectfFragmentNewSensors();
		case SDCardWithoutPermission:
			return new SubjectfFragmentSDCardWithoutPermission();
		case NewSMSFramework:
			return new SubjectfFragmentNewSMSFramework();

		default:
			return new AbstractSubjectfFragment() {
			};
		}
	}

	public static AbstractSubjectfFragment getFragment(String id) {
		return getFragment(Elements.valueOf(id));
	}
}

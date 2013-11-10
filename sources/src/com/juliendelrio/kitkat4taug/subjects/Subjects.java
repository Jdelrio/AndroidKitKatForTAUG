package com.juliendelrio.kitkat4taug.subjects;

public class Subjects {
	public enum Elements {
		NewSensors, SDCardWithoutPermission, PrintingFramework, NewSMSFramework, FullScreenMode
	}

	public static AbstractSubjectfFragment getFragment(Elements element) {
		switch (element) {
		case NewSensors:
			return new SubjectfFragmentNewSensors();
		case SDCardWithoutPermission:
			return new SubjectfFragmentSDCardWithoutPermission();
		case NewSMSFramework:
			return new SubjectfFragmentNewSMSFramework();
		case FullScreenMode:
			return new SubjectfFragmentFullScreenMode();
		default:
			return new AbstractSubjectfFragment() {
			};
		}
	}

	public static AbstractSubjectfFragment getFragment(String id) {
		return getFragment(Elements.valueOf(id));
	}
}

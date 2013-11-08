package com.juliendelrio.kitkat4taug.subjects;

public class Subjects {
	public enum Elements {
		NewStorageAPI
	}

	public static AbstractSubjectfFragment getFragment(Elements element) {
		return new AbstractSubjectfFragment() {
		};
	}

	public static AbstractSubjectfFragment getFragment(String id) {
		return new AbstractSubjectfFragment() {
		};
	}
}

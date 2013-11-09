package com.juliendelrio.kitkat4taug.subjects;

public class Subjects {
	public enum Elements {
		NewStorageAPI, SDCardWithoutPermission
	}

	public static AbstractSubjectfFragment getFragment(Elements element) {
		switch (element) {
		case NewStorageAPI:
			return new SubjectfFragmentNewStorageApi();
		case SDCardWithoutPermission:
			return new SubjectfFragmentSDCardWithoutPermission();

		default:
			return new AbstractSubjectfFragment() {
			};
		}
	}

	public static AbstractSubjectfFragment getFragment(String id) {
		return getFragment(Elements.valueOf(id));
	}
}

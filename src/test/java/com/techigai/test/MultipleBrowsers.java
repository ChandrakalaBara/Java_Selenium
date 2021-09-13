package com.techigai.test;

import com.techigai.commonLib.*;

public class MultipleBrowsers {

	public static void main(String[] args) {
		WebPage wp = new WebPage();
		wp.createMultipleBrowserInstances();
		wp.closeAllBrowserInstances();
	}

}

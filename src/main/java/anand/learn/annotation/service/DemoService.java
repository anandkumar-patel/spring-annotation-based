package anand.learn.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	private int demoId;
	private String demoName;
	
	@Autowired
	public DemoService() {
		this.demoId = 1;
		this.demoName = "One";
	}

	public int getDemoId() {
		return demoId;
	}

	public void setDemoId(int demoId) {
		this.demoId = demoId;
	}

	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}

}

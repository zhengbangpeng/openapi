package cn.edu.zju.ccnt.openapi.domain;
/**
 * 
 * @author zheng
 * 2015年4月17日 下午4:00:25
 */
public class Reply extends Article {
	
	private Problem problem;

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	
}

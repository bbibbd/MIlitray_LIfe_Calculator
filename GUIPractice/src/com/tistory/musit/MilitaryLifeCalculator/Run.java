package com.tistory.musit.MilitaryLifeCalculator;

//import java.text.SimpleDateFormat;
//import java.util.Scanner;
class Run {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	private int sy, sm, sd, ey, em, ed;

	public int getSy() {
		return sy;
	}


	public void setSy(int sy) {
		this.sy = sy;
	}


	public int getSm() {
		return sm;
	}


	public void setSm(int sm) {
		this.sm = sm;
	}


	public int getSd() {
		return sd;
	}


	public void setSd(int sd) {
		this.sd = sd;
	}


	public int getEy() {
		return ey;
	}


	public void setEy(int ey) {
		this.ey = ey;
	}


	public int getEm() {
		return em;
	}


	public void setEm(int em) {
		this.em = em;
	}


	public int getEd() {
		return ed;
	}


	public void setEd(int ed) {
		this.ed = ed;
	}


	public String getName(){
		return name;
	}
	
	public Run() {
		
	}

	public Run(String name, int sy, int sm, int sd, int ey, int em, int ed) {
		this.name = name;
		this.sy = sy;
		this.sm = sm;
		this.sd = sd;
		this.ey = ey;
		this.em = em;
		this.ed = ed;
	}

	PeriodCalculator calculator = new PeriodCalculator();
	
	StringBuilder  finalResult = new StringBuilder("");

	public void calculating(){

		calculator.setStartYear(sy);
		calculator.setStartMonth(sm);
		calculator.setStartDate(sd);

		calculator.setEndYear(ey);
		calculator.setEndMonth(em);
		calculator.setEndDate(ed);
		calculator.calculatingPeriode();

		//이미 전역한 사람일 경우
		if(calculator.getRemainDays()<=0){
			finalResult.append("고인이시네요. 프로그램을 종료합니다.");
			return  ;
		}

		//전체 군생활 한 일수, 남은 일수
		finalResult.append( String.format("- %s님의 전체 군생활: %d년 %d개월 %d일\n(총 %d일) 중\n%d일(%.4f%%) 하셨으며, \n%d일 남으셨습니다.\n\n",
				name,calculator.getBetweenYear(), calculator.getBetweenMonth(), calculator.getBetweenDay(), calculator.getTotalDays(),
				calculator.getPastDays(), (double)calculator.getPercentage(),calculator.getRemainDays()));

	
		
		

		//특정 퍼센트(10%, 20%, 25%, 30%, 33%, ..., 90%)까지 남은 일수
		DayCalculator dayCalculator = new DayCalculator();
		
		finalResult.append(String.format("- 하루에 %.3f%%씩 증가합니다. \n10%%까지는 %d일 (%s)\n20%%까지는 %d일 (%s)\n25%%까지는 %d일 (%s) \n30%%까지는 %d일 (%s)\n33%%까지는 %d일 (%s)\n40%%까지는 %d일 (%s)\n50%%까지는 %d일 (%s)\n60%%까지는 %d일 (%s)\n66%%까지는 %d일 (%s)\n70%%까지는 %d일 (%s)\n75%%까지는 %d일 (%s)\n80%%까지는 %d일 (%s)\n90%%까지는 %d일 (%s)\n남았습니다.\n"
				,calculator.dayPercentage()
				,calculator.remainPercentage(10) ,dayCalculator.addDays(calculator.remainPercentage(10))
				,calculator.remainPercentage(20) ,dayCalculator.addDays(calculator.remainPercentage(20))
				,calculator.remainPercentage(25) ,dayCalculator.addDays(calculator.remainPercentage(25))
				,calculator.remainPercentage(30) ,dayCalculator.addDays(calculator.remainPercentage(30))
				,calculator.remainPercentage(33) ,dayCalculator.addDays(calculator.remainPercentage(33))
				,calculator.remainPercentage(40) ,dayCalculator.addDays(calculator.remainPercentage(40))
				,calculator.remainPercentage(50) ,dayCalculator.addDays(calculator.remainPercentage(50))
				,calculator.remainPercentage(60) ,dayCalculator.addDays(calculator.remainPercentage(60))
				,calculator.remainPercentage(66) ,dayCalculator.addDays(calculator.remainPercentage(66))
				,calculator.remainPercentage(70) ,dayCalculator.addDays(calculator.remainPercentage(70))
				,calculator.remainPercentage(75) ,dayCalculator.addDays(calculator.remainPercentage(75))
				,calculator.remainPercentage(80) ,dayCalculator.addDays(calculator.remainPercentage(80))
				,calculator.remainPercentage(90) ,dayCalculator.addDays(calculator.remainPercentage(90))));


		//100일, 200일 ,,, 500일 깨졌는지
		
		finalResult.append(String.format("\n- 입대 D+ \n100일은 %d일 (%s)\n200일은 %d일 (%s)\n300일은 %d일 (%s)\n400일은 %d일 (%s)\n500일은 %d일 (%s) \n남으셨습니다.\n\n- 전역 D-\n500일은 %d일 (%s)\n400일은 %d일 (%s)\n300일은 %d일 (%s)\n200일은 %d일 (%s)\n100일은 %d일 (%s)\n남으셨습니다.\n",
				calculator.pastHund(100), dayCalculator.addDays(calculator.pastHund(100)),
				calculator.pastHund(200), dayCalculator.addDays(calculator.pastHund(200)),
				calculator.pastHund(300), dayCalculator.addDays(calculator.pastHund(300)),
				calculator.pastHund(400), dayCalculator.addDays(calculator.pastHund(400)),
				calculator.pastHund(500), dayCalculator.addDays(calculator.pastHund(500)),
				calculator.remainHund(500), dayCalculator.addDays(calculator.remainHund(500)),
				calculator.remainHund(400), dayCalculator.addDays(calculator.remainHund(400)),
				calculator.remainHund(300), dayCalculator.addDays(calculator.remainHund(300)),
				calculator.remainHund(200), dayCalculator.addDays(calculator.remainHund(200)),
				calculator.remainHund(100), dayCalculator.addDays(calculator.remainHund(100))));
		

		//입대한지 1년 넘게 남았는지,  1년이 지났는지
		switch(calculator.oneYear()){
		case 1: finalResult.append(String.format("\n- 1년(D-365일)은 깨지셨으며, \n입대 1년차까지 %d일 남으셨습니다.",365-calculator.getPastDays()));
		break;
		case 2:  finalResult.append("\n- 1년(D-365일)은 깨지셨으며, \n딱 입대한지 1주년이십니다. 축하드립니다^^");
		break;
		case 3:  finalResult.append("\n- 1년(D-365일)은 깨지셨으며, \n입대한지 1년차도 이미 지났습니다.");
		break;
		case 4: finalResult.append("\n- 딱 1년 남으셨습니다..^^");
		break;
		case 5:finalResult.append(String.format("\n- 아직 1년(D-365일)도 안깨지셨습니다. \n1년 깨지기까지 %d일 남았으며 (%s), \n%d일 후 입대 1년차가 됩니다.",calculator.getRemainDays()-365, dayCalculator.addDays(calculator.getRemainDays()-365),365-calculator.getPastDays()));
		default:  break;
		}

		//지금까지 대강 먹은 짬밥
		finalResult.append(String.format("\n\n- 입대 후 지금까지 드신 짬은 %d끼 이며, \n앞으로 %d끼 더 드셔야 합니다.\n\n",calculator.eatedJjam(),calculator.willEatJjam()));
		//배식조 몇번, 근무 몇번, 교회 몇번
		finalResult.append(String.format("- 전역할때까지 근무는 약 %d번, 교회는 %d번, \n배식조는 %d번(%d일) 남았습니다.\n",calculator.howManyGeunmu(),calculator.howManyChurch(),calculator.howManyBasik(1),calculator.howManyBasik(2)));
		//군생활을 24시간으로 표현하였을 때
		finalResult.append(String.format("\n- 군생활이 24시간이라면?, \n현재 시각은 "+calculator.dayConvert()+"입니다.\n\n"));
		//어느정도 짬 찼는지 보여줌
		switch(calculator.jjam(calculator.getPercentage())){
		case 1:finalResult.append("답없죠...?"); break;
		case 2: finalResult.append("여전히 답이 없네요."); break;
		case 3: finalResult.append("착각하지마세요. 아직 짬찌입니다."); break;
		case 4:finalResult.append("열심히 달렸으나 아직은 짬찌");  break;
		case 5: finalResult.append("짬 좀 찼네요..?");  break;
		case 6: finalResult.append("사실상 실세");  break;
		case 7: finalResult.append("전역이 보이기 시작한다..!");  break;
		case 8: finalResult.append("혹시 전문하사는...???");  break;
		case 9: finalResult.append("말년");  break;
		default:  finalResult.append("고인");  break;
		}
		finalResult.append("\n-------------------------------------------------------");
	}

	private double remainPercentage = calculator.getPercentage();  

	public double getPercentage(){
		return remainPercentage;
	}

	public StringBuilder getFinalResult() {
		return finalResult;
	}



}
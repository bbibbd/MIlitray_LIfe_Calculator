package com.tistory.musit.MilitaryLifeCalculator;

import java.text.DecimalFormat;

class Run {
	private String name;
	PeriodCalculator calculator = new PeriodCalculator();
	private int betweenY = calculator.getBetweenYear();
	private int remainDays;
	
	public int getRemainDays() {
		return remainDays;
	}

	public void setRemainDays(int remainDays) {
		this.remainDays = remainDays;
	}

	public int getBetweenYaer() {
		return betweenY;
	}
	
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
	


	public Run(String name, int sy, int sm, int sd, int ey, int em, int ed) {
		this.name = name;
		this.sy = sy;
		this.sm = sm;
		this.sd = sd;
		this.ey = ey;
		this.em = em;
		this.ed = ed;
	}


	StringBuilder  finalResult = new StringBuilder("");	//각 method의 결과를 String으로 저장하기위해 StringBuilder을 사용함
	private double percentage;

	public void calculating(){

		calculator.setStartYear(sy);
		calculator.setStartMonth(sm);
		calculator.setStartDate(sd);
		calculator.setEndYear(ey);
		calculator.setEndMonth(em);
		calculator.setEndDate(ed);
		calculator.calculatingPeriode();
		
		this.remainDays = calculator.getRemainDays();
		this.percentage = (double)calculator.getPercentage();
		
		//군생활이 1년도 안되는 경우(즉, 잘못 입력한 경우)
		if(calculator.getBetweenYear()==0) {
			finalResult.append(String.format("%s님..잘못입력하신거 같습니다.\n다시 입력해 주시길.....\n\n", name));
			return ;
		}
		//이미 전역한 사람일 경우
		if(calculator.getRemainDays()<=0){
			finalResult.append(String.format("%s님은 이미 전역하셨습니다...\n그래도 결과가 궁금하죠..?.\n\n", name));
		}
		//아직 입대하지 않은 사람인 경우
		if(calculator.getPastDays()<0) {
			finalResult.append(String.format("%s님은 아직 입대도 하지 않으셨네요...ㅎ\n그래도 궁금하시다면야...\n\n", name));
		}
		//전체 군생활 한 일수, 남은 일수
		finalResult.append(String.format("- %s님의 전체 군생활: %d년 %d개월 %d일\n(총 %d일) 중\n%d일(%.4f%%) 하셨으며, \n%d일 남으셨습니다.\n\n",
				name,calculator.getBetweenYear(), calculator.getBetweenMonth(), calculator.getBetweenDay(), calculator.getTotalDays(),
				calculator.getPastDays(), (double)calculator.getPercentage(),calculator.getRemainDays()));	
		
		//몇시간동안 일했고, 최저시급으로 얼마나 벌었는지
		int hours = 24*calculator.getPastDays();
		double workHours = calculator.getPastDays()*(5.0/7.0)*9;	//일주일에 5일동안 하루에 9시간씩
		double wage = workHours*8590;	//2020년기준 최저시급 8590원
		DecimalFormat df = new DecimalFormat("#,##0");
		double lol = hours*(2.0/3.0);
		int book = hours/6;
		finalResult.append(String.format("총 %s시간(일과 %s시간)동안 \n군생활을 하셨으며 만약 사회에 있었다면 \n최저시급으로 %s원 모았고\n롤은 %s판할 수 있으며, \n책은 %s권 읽을수 있고,\n여자친구는 0번 사귈 수 있습니다.\n\n", df.format(hours),df.format(workHours),df.format(wage),df.format(lol),df.format(book)));

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
		//군생활을 24시간으로 표현하였을 때
		finalResult.append(String.format("- 군생활이 24시간이라면?, \n현재 시각은 "+calculator.dayConvert()+"입니다.\n\n"));
		//어느정도 짬 찼는지 보여줌
		switch(calculator.jjam(calculator.getPercentage())){
		case 1:finalResult.append("답없죠...?"); break;	//20%이하일 경우
		case 2: finalResult.append("여전히 답이 없네요."); break;	//30%이하일 경우
		case 3: finalResult.append("착각하지마세요. 아직 짬찌입니다."); break;	//40%이하일 경우
		case 4:finalResult.append("열심히 달렸으나 아직은 짬찌");  break;	//50%이하일 경우
		case 5: finalResult.append("이제 겨우 반 넘음ㅋ");  break;	//60%이하일 경우
		case 6: finalResult.append("짬이 조금씩 차는게 느껴지시나요?\n하지만 아직도 한참 남았네요^^");  break;	//70%이하일 경우
		case 7: finalResult.append("이제야 군생활이 좀 편해지셨겠어요~");  break;	//80%이하인 경우
		case 8: finalResult.append("전역이 보이시나요?..그렇담 착각입니다^^");  break;	//90%이하인 경우
		case 9: finalResult.append("전역이 보인다!");  break;	//100%이하일 경우
		default:  finalResult.append("고인");  break;
		}
		finalResult.append("\n-------------------------------------------------------");
		
	}


	public double getPercentage(){
		return percentage;
	}

	public StringBuilder getFinalResult() {
		return finalResult;
	}



}
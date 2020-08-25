package com.tistory.musit.MilitaryLifeCalculator;

import java.time.Period;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class PeriodCalculator extends DataManagement {

	// DataManagement에 있는 변수 세팅
	public void calculatingPeriode() {
		LocalDate today = LocalDate.now();
		LocalDate start = LocalDate.of(startYear, startMonth, startDate);
		LocalDate end = LocalDate.of(endYear, endMonth, endDate);
		Period between = Period.between(start, end);

		betweenYear = between.getYears();
		betweenMonth = between.getMonths();
		betweenDays = between.getDays();

		totalDays = (int) ChronoUnit.DAYS.between(start, end) + 1;
		remainDays = (int) ChronoUnit.DAYS.between(today, end);
		remainWeeks = (int) ChronoUnit.WEEKS.between(today, end);
		pastDays = (int) ChronoUnit.DAYS.between(start, today) + 1;
		percentage = pastDays * 100.0 / totalDays;
	}

	// 먹은 짬 수
	public int eatedJjam() {
		return pastDays * 3;// 하루에 3끼씩 먹는다고 한 후 계산
	}

	// 먹어야 하는 짬 수
	public int willEatJjam() {
		return remainDays * 3;
	}

	// 지금까지 한 퍼센트
	public double dayPercentage() {
		double dayP = 100.0 / totalDays;
		return dayP;
	}

	// 특정 퍼센트까지 남은 일수 구하는 method
	public int remainPercentage(int percentage) { // percentage를 인수로 받아
		int quarter = totalDays / 4; // 전체 군생활의 1/4
		int half = totalDays / 2; // 전체 군생활의 1/2
		int halfAndQuarter = (int) (totalDays * 0.75); // 전체 군생활의 3/4
		int oneOverThree = totalDays / 3; // 전체 군생활의 1/3 --> 66%까지 남은 일수 구할때 씀

		int tenP = (int) (totalDays * 0.1); // 전체 군생활의 10%
		int twentyP = (int) (totalDays * 0.2); // 전체 군생활의 20%
		int thirtyP = (int) (totalDays * 0.3); // 전체 군생활의 30%
		int fortyP = (int) (totalDays * 0.4); // 전체 군생활의 40%
		int sixtyP = (int) (totalDays * 0.6); // 전체 군생활의 60%
		int seventyP = (int) (totalDays * 0.7); // 전체 군생활의 70%
		int eightyP = (int) (totalDays * 0.8); // 전체 군생활의 80%
		int ninetyP = (int) (totalDays * 0.9); // 전체 군생활의 90%

		int remainQuarter = remainDays - halfAndQuarter; // 1/4 (25%)까지 남은 일수
		int remainHalf = remainDays - half; // 1/2(50%)까지 남은 일수
		int remainOneOverThree = remainDays - 2 * oneOverThree; // 1/3(33%)까지 남은 일수
		int remainTwoOverThree = remainDays - oneOverThree; // 2/3(66%)까지 남은 일수
		int remainHalfAndQuarter = remainDays - quarter; // 3/4(75%)까지 남은 일수

		int remainTenP = remainDays - ninetyP; // 10%까지 남은 일수
		int remainTwentyP = remainDays - eightyP; // 20%까지 남은 일수
		int remainThirtyP = remainDays - seventyP; // 30%까지 남은 일수
		int remainFortyP = remainDays - sixtyP; // 40%까지 남은 일수
		int remainSixtyP = remainDays - fortyP; // 60%까지 남은 일수
		int remainSeventyP = remainDays - thirtyP; // 70%까지 남은 일수
		int remainEightyP = remainDays - twentyP; // 80%까지 남은 일수
		int remainNinetyP = remainDays - tenP; // 90%까지 남은 일수

		if (percentage == 10)
			return remainTenP; // 10%일 시 남은 일수
		else if (percentage == 20)
			return remainTwentyP;
		else if (percentage == 25)
			return remainQuarter;
		else if (percentage == 30)
			return remainThirtyP;
		else if (percentage == 33)
			return remainOneOverThree;
		else if (percentage == 40)
			return remainFortyP;
		else if (percentage == 50)
			return remainHalf;
		else if (percentage == 60)
			return remainSixtyP;
		else if (percentage == 66)
			return remainTwoOverThree;
		else if (percentage == 70)
			return remainSeventyP;
		else if (percentage == 75)
			return remainHalfAndQuarter;
		else if (percentage == 80)
			return remainEightyP;
		else if (percentage == 90)
			return remainNinetyP;
		else
			return 0;

	}

	// 퍼센트에 따라 어느정도 짬 찼는지 보여주는 method
	public int jjam(double percentage) {
		int jjam;
		if (percentage < 20)
			jjam = 1;
		else if (percentage < 30)
			jjam = 2;
		else if (percentage < 40)
			jjam = 3;
		else if (percentage < 50)
			jjam = 4;
		else if (percentage < 60)
			jjam = 5;
		else if (percentage < 70)
			jjam = 6;
		else if (percentage < 80)
			jjam = 7;
		else if (percentage <= 90)
			jjam = 8;
		else if (percentage < 100)
			jjam = 9;
		else
			jjam = 10;
		return jjam;
	}

	// D-365일, D+365일까지 남은 일수
	public int oneYear() {
		System.out.println();
		if (remainDays < 365) { // 군생활이 1년보다 적게 남았을 경우
			if (pastDays < 365)
				return 1; // 1년 넘게 군생활 한 경우
			else if (pastDays == 365)
				return 2; // 딱 1년한 경우
			else
				return 3; // 1년보다 적게 군생활 한 경우
		} else if (remainDays == 365)
			return 4; // 딱 1년 넘은 경우
		else
			return 5; // 군생활 1년 넘게 남은 경우
	}

	// 입대한지 100일 단위로 남은 일수를 구해주는 method
	public int pastHund(int pHund) {
		if (pHund == 100)
			return 100 - pastDays; // 입대 100일까지 남은 일수
		else if (pHund == 200)
			return 200 - pastDays; // 입대 200일까지 남은 일수
		else if (pHund == 300)
			return 300 - pastDays; // 입대 300일까지 남은 일수
		else if (pHund == 400)
			return 400 - pastDays; // 입대 400일까지 남은 일수
		else if (pHund == 500)
			return 500 - pastDays; // 입대 500일까지 남은 일수
		else
			return 0;
	}

	// 전역까지 100일 단위로 남은 일수를 구해주는 method
	public int remainHund(int rHund) {
		if (rHund == 500)
			return remainDays - 500; // 전역 500일까지 남은 일수
		else if (rHund == 400)
			return remainDays - 400; // 전역 400일까지 남은 일수
		else if (rHund == 300)
			return remainDays - 300; // 전역 300일까지 남은 일수
		else if (rHund == 200)
			return remainDays - 200; // 전역 200일까지 남은 일수
		else if (rHund == 100)
			return remainDays - 100; // 전역 100일까지 남은 일수
		else
			return 0;
	}

	// 군생활을 하루 24시간 일과로 표현했을 경우(00:00~23:59까지)
	public String dayConvert(){
		int hours= (int)(24*(percentage/100));
		int minutes = (int)((24.0*(percentage/100.0)-hours)*60);
		String day = hours+"시 "+ minutes+"분. ";

		if(hours>0&&hours<6) day = day + "아직 취침 중";
		else if(hours == 6){
			if (minutes<30) day = day + "아직 취침 중";
			else if (minutes<50)  day = day + "기상 후 아침점호 집합 중...";
			else  day = day + "연병장에서 아침 점호집합 중...";
		}
		else if(hours==7){
			if (minutes<30) day = day + "아침점호, 아침뜀걸음 중^^";
			else if (minutes<50)  day = day + "빠밥 식사 중";
			else  day = day + "늦밥 식사 중";
		}
		else if(hours==8){
			if (minutes<20) day = day + "늦밥 식사 중";
			else if (minutes<30)  day = day + "일과준비 중";
			else  day = day + "오전일과 진행 중...";
		}
		else if(hours>8&&hours<11)  day = day + "오전일과 진행 중...";
		else if(hours==11){
			if (minutes<30) day = day + "오전일과 진행 중...";
			else day = day + "점심시간";
		}
		else if(hours==12)  day = day + "점심시간";
		else if(hours>=13&&hours<15) day = day + "오후 일과 진행 중...";
		else if(hours == 15){
			if (minutes<30) day = day + "오후 일과 진행 중...";
			else day = day + "체단 집합 중...";
		} 
		else if(hours <17) {
			day = day + "체단중...";
		}
		else if(hours==17){
			if (minutes==0)  day = day + "체단 중...";
			else if(minutes<30)  day = day + "체단 후 휴식 중...";
			else	day = day + "개인정비!!!!";
		}
		else if(hours<18) {
			day = day + "개인정비!!!!";
		}
		

		else if(hours==18){
			if(hours<30)  day = day + "빠밥 저녁식사중...";
			else  day = day + "늦밥 저녁식사 중...";
		}
		else if(hours>18&&hours<21)  day = day + "개인정비!!!!";
		else if(hours ==21) {
			if(minutes <10)	day = day+"빠빠빠 빠빠빠 빠빠빠빠빠빠빠....\n휴대폰 반납중";
			else if(minutes<30) day = day + "임무분담제에 의한 청소 중...";
			else if(minutes <45) day = day + "점호중";
			else	day = day + "점호끝!";
		}

		else if(hours >= 22)  day = day + "연등 중...";
		return day;
	}

	// 남은 군생활 동안 배식조 몇 번, 며칠 해야 하는지 구하는 method
	public int howManyBasik(int n) {
		int basikWeeks = remainWeeks / 4; // 배식조 몇 번 해야하는가 - 4주에 한 번 근무들어감
		int basikDays = basikWeeks * 7; // 배식조 며칠 해야하는가 - 1주일에 7일 배식을 하기 때문에

		if (n == 1)
			return basikWeeks;
		else
			return basikDays;
	}

	// 남은 군생활 동안 교회 몇 번 가야하는지 구해주는 method
	public int howManyChurch() {
		return remainWeeks; // 1주일에 한 번 교회를 감
	}

	// 남은 군생활 동안 근무 몇 번 들어가는지 구해주는 method
	public int howManyGeunmu() {
		int geunmu = (int) remainWeeks * 3; // 1주일에 3번 근무를 들어간다고 생각했을 때
		return geunmu;

	}
}
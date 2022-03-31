package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomGreedy {

	static class Meeting implements Comparable<Meeting>{ // 내부 클래스 정렬을 위해 Comparable implements
		int start, end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end-o.end : this.start-o.start; // 3항 연산자로 처리
			// 종료 시간이 같으면 시작 시간을 기준으로 오름 차순, 그게 아니면 종료 시간 기준으로 오름차순
			// 나에서 상대를 빼는 순서가 오름차순 상대에서 나를 빼는게 내림차순
		}
	}
	
	public static void main(String[] args) {
		// TODO 회의실 배정 문제
		
		Scanner sc = new Scanner(System.in);
		
		int count =  sc.nextInt(); //회의 수
		
		// Meeting 타입 배열 생성
		Meeting[] meetings = new Meeting[count];
		
		for(int i=0; i<count; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		// 회의 목록을 종료시간 기준으로 오름차순, 종료시간이 같다면 시작시간 기준으로 오름차순 정렬.
		
		List<Meeting> result = getSchedule(meetings);
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		
		for(Meeting meeting : result) {
			sb.append(meeting.start).append(" ").append(meeting.end).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static List<Meeting> getSchedule(Meeting[] meetings){
		ArrayList<Meeting> result = new ArrayList<Meeting>(); // Meeting 객체들 저장할 리스트 생성
		
		Arrays.sort(meetings); // 정렬 수행
	
		result.add(meetings[0]); // 첫 번째 회의(종료 시간이 가장 빠른 회의) 는 무조건 집어 넣는다
		
		int size=meetings.length; // 반복문 효율을 위해 임시 저장
		for(int i=1 ; i<size; i++) {
			// 직전회의의 종료시간과 현재회의의 시작시간 비교
			if(result.get(result.size()-1).end <= meetings[i].start) {   // 마지막 인덱스를 가져와서 
				result.add(meetings[i]);
			}
		}
		return result;
		
	}

}

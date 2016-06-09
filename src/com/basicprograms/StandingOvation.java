package com.basicprograms;
/**
 * Google Code Jam 
 * Qualification Round 2015
 * 
 * Standing Ovation problem
 * 
 * Sample input
 * 
 * 4
 * 4 11111
 * 4 09
 * 5 110011
 * 0 1
 * 
 * Case#1: 
 * 
 * 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StandingOvation {
	public static void main(String[] args) {

		// The name of the files to open.
		String inputFileName = "src/A-small-attempt0.in";
		String outputFileName = "src/A-small-attempt0.out";

		try {
			FileReader fileReader = new FileReader(inputFileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			FileWriter fileWriter = new FileWriter(outputFileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			int testCaseCnt = Integer.valueOf(bufferedReader.readLine());
			int cnt = 1;

			while (testCaseCnt > 0) {
				String input = bufferedReader.readLine();
				String[] inputArr = input.split(" ");

				int sMax = Integer.valueOf(inputArr[0]);
				String inputPeopleString = inputArr[1];

				int[] inputPeople = new int[sMax + 1];
				char[] inputPeopleChar = inputPeopleString.toCharArray();
				for (int c = 0; c < sMax + 1; c++) {
					inputPeople[c] = Character
							.getNumericValue(inputPeopleChar[c]);
				}
				testCaseCnt--;

				bufferedWriter.write("Case #" + cnt + ": "
						+ standingOvation(inputPeople));
				bufferedWriter.newLine();
				cnt++;
			}
			bufferedReader.close();
			bufferedWriter.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file");
		} catch (IOException ex) {
			System.out.println("Error reading file");
		}

	}

	private static int standingOvation(int[] inputPeople) {
		int answer = 0;
		int standingPplCnt = 0;

		for (int i = 0; i < inputPeople.length; i++) {
			if (i > standingPplCnt) {
				answer += i - standingPplCnt;
				standingPplCnt += answer;
			}
			standingPplCnt += inputPeople[i];
		}
		return answer;
	}
}

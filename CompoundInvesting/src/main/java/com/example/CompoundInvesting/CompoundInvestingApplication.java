package com.example.CompoundInvesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompoundInvestingApplication {

	public static void main(String[] args) {
		int monthlyContribution = 100, years = 2;
		double principal = 100.0, annualReturn = 0.1;

		for (int i = 1; i <= years; i++) {
			int totalContributions = 12 * i * monthlyContribution;
			double result = calculateReturn(monthlyContribution, i, principal, annualReturn);
			double interest = result - (principal + totalContributions);
			System.out.println("Return for year " + i + ": " + String.format("%.2f", result));
			System.out.println("Total contributions for year " + i + ": " + totalContributions);
			System.out.println("Total interest for year " + i + ": " + String.format("%.2f", interest));
			System.out.println("");
		}

		// SpringApplication.run(CompoundInvestingApplication.class, args);
	}

	private static double calculateReturn(int monthlyContribution, int years, double principal, double annualReturn) {
		double pow = Math.pow(1 + annualReturn / 12, 12 * years);
		double calc = principal * pow
				+ monthlyContribution * ( (pow - 1) / (annualReturn / 12) );
		return calc;
	}
}

package cc.hansam.tools;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 工资发放计算器
 *
 * @author hansam 945210972@qq.com
 * @date 2017年8月5日上午10:56:13
 */
public class InTimeSalaryCal {
    private static final double TOTAL_MONEY = 0; // 税前总工资

    // 汇缴基数
    private static final double SOCIALSECURITYBASE_A = 4500; // 社保汇缴基数[养老、失业（农村户口没有）]
    private static final double SOCIALSECURITYBASE_B = 4624; // 社保汇缴基数[工伤、生育、医疗2%+3]
    private static final double HOUSINGFUNDBASE = TOTAL_MONEY; // 公积金汇缴基数

    // 个人应缴比例
    private static final double PENSIONINSURANCE_PERSON = 0.08; // 养老
    private static final double MEDICALINSURANCE_PERSON = 0.02; // 医疗
    private static final double UNEMPLOYMENTINSURANCE_PERSON = 0.002; // 失业
    private static final double OCCUPATIONALINJURY_PERSON = 0; // 工伤
    private static final double BEAR_PERSON = 0; // 生育

    private static final double HOUSINGFUND_PERSON = 0.12; // 公积金

    // 单位应缴比例
    private static final double PENSIONINSURANCE_COMPANY = 0.19; // 养老
    private static final double MEDICALINSURANCE_COMPANY = 0.1; // 医疗
    private static final double UNEMPLOYMENTINSURANCE_COMPANY = 0.08; // 失业
    private static final double OCCUPATIONALINJURY_COMPANY = 0.004; // 工伤
    private static final double BEAR_COMPANY = 0.008; // 生育

    private static final double HOUSINGFUND_COMPANY = 0.12; // 公积金

    // 补助
    private static final double FOOD_SUBSIDY = 420; // 饭补
    private static final double COMMUNICATION_SUBSIDY = 200; // 通信补助
    private static final double TRAFFIC_SUBSIDY = 105; // 交通补助
    private static final double TOTAL_SUBSIDY = FOOD_SUBSIDY + COMMUNICATION_SUBSIDY + TRAFFIC_SUBSIDY;


    // ====================================个人

    public static double getPensionInsuranceByPerson() {
        return SOCIALSECURITYBASE_A * PENSIONINSURANCE_PERSON;

    }

    public static double getMedicalInsuranceByPerson() {
        return SOCIALSECURITYBASE_B * MEDICALINSURANCE_PERSON + 3;

    }

    public static double getUnemploymentInsuranceByPerson() {
        // return SOCIALSECURITYBASE_A * UNEMPLOYMENTINSURANCE_PERSON;
        return 0;

    }

    public static double getHousingFundByPerson() {
        return HOUSINGFUNDBASE * HOUSINGFUND_PERSON;

    }

    public static double getTaxByPerson(double money) {
        double tmp = money - 3500;

        if (0 < tmp && tmp <= 1500) {
            return tmp * 0.03;
        } else if (1500 < tmp && tmp <= 4500) {
            return tmp * 0.1 - 105;
        } else if (4500 < tmp && tmp <= 9000) {
            return tmp * 0.2 - 555;
        } else if (9000 < tmp && tmp <= 35000) {
            return tmp * 0.25 - 1005;
        }
        return 0;
    }

    // ====================================单位
    public static double getPensionInsuranceByCompany() {
        return SOCIALSECURITYBASE_A * PENSIONINSURANCE_COMPANY;

    }

    public static double getMedicalInsuranceByCompany() {
        return SOCIALSECURITYBASE_B * MEDICALINSURANCE_COMPANY;

    }

    public static double getUnemploymentInsuranceByCompany() {
        // return SOCIALSECURITYBASE_A * UNEMPLOYMENTINSURANCE_COMPANY;
        return 0;

    }

    public static double getOccupationalInjuryInsuranceByCompany() {
        return SOCIALSECURITYBASE_B * OCCUPATIONALINJURY_COMPANY;

    }

    public static double getBearInsuranceByCompany() {
        return SOCIALSECURITYBASE_B * BEAR_COMPANY;

    }

    public static double getHousingFundByCompany() {
        return HOUSINGFUNDBASE * HOUSINGFUND_COMPANY;

    }


    /**
     * 金额格式化
     */
    public static String getFormat(double money) {
        DecimalFormat format = new DecimalFormat("#.##"); // 金额格式化
        return format.format(money);
    }


    public static void main(String[] args) {
        double pensionInsuranceByPerson = getPensionInsuranceByPerson();
        double medicalInsuranceByPerson = getMedicalInsuranceByPerson();
        double unemploymentInsuranceByPerson = getUnemploymentInsuranceByPerson();
        double housingFundByPerson = getHousingFundByPerson();

        double allDebit = pensionInsuranceByPerson + medicalInsuranceByPerson + unemploymentInsuranceByPerson
                + housingFundByPerson;

        // 代缴后金额
        double money = TOTAL_MONEY - allDebit;
        double taxByPerson = getTaxByPerson(money + TOTAL_SUBSIDY);
        double resultMoney = money - taxByPerson + TOTAL_SUBSIDY;

        double pensionInsuranceByCompany = getPensionInsuranceByCompany();
        double medicalInsuranceByCompany = getMedicalInsuranceByCompany();
        double unemploymentInsuranceByCompany = getUnemploymentInsuranceByCompany();
        double occupationalInjuryInsuranceByCompany = getOccupationalInjuryInsuranceByCompany();
        double bearInsuranceByCompany = getBearInsuranceByCompany();
        double housingFundByCompany = getHousingFundByCompany();
        double totoalByCompany = pensionInsuranceByCompany + medicalInsuranceByCompany + unemploymentInsuranceByCompany
                + occupationalInjuryInsuranceByCompany + bearInsuranceByCompany + housingFundByCompany;

        System.out.println("================个人汇缴记录================");
        System.out.println("养老：" + getFormat(pensionInsuranceByPerson));
        System.out.println("医疗：" + getFormat(medicalInsuranceByPerson));
        // System.out.println("失业：" + getFormat(unemploymentInsuranceByPerson));
        System.out.println("公积金：" + getFormat(housingFundByPerson));
        System.out.println("  	--扣缴总计：" + getFormat(allDebit));
        System.out.println("	--工资净额：" + getFormat(money));
        System.out.println("	--补助总额：" + getFormat(TOTAL_SUBSIDY));
        System.out.println("个人所得税：" + getFormat(taxByPerson));
        System.out.println("最后所得：" + getFormat(resultMoney));
        System.out.println();

        System.out.println("================单位汇缴记录================");
        System.out.println("养老：" + getFormat(pensionInsuranceByCompany));
        System.out.println("医疗：" + getFormat(medicalInsuranceByCompany));
        // System.out.println("失业：" + getFormat(unemploymentInsuranceByCompany));
        System.out.println("工伤：" + getFormat(occupationalInjuryInsuranceByCompany));
        System.out.println("生育：" + getFormat(bearInsuranceByCompany));
        System.out.println("公积金：" + getFormat(housingFundByCompany));
        System.out.println("	--总计：" + getFormat(totoalByCompany));

    }

}

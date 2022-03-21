package blackjack.domain;

import blackjack.utils.Validator;

public class BettingMoney {

    private static final int INIT_DEALER_PROFIT_VALUE = 0;
    private static final String POSITIVE_NUMBER_FORMAT = "^[1-9]\\d*$";
    private static final String TEN_UNITS_NUMBER_FORMAT = "^[1-9]\\d*0$";
    private static final String POSITIVE_NUMBER_MESSAGE = "배팅 금액은 양수로 입력해주세요.";
    private static final String TEN_UNITS_NUMBER_MESSAGE = "배팅 금액은 10원 단위로 입력해주세요.";

    private final int money;

    private BettingMoney(int money) {
        this.money = money;
    }

    public static BettingMoney of(final String input) {
        Validator.validateNullOrEmpty(input);
        validate(input);
        return new BettingMoney(Integer.parseInt(input));
    }

    public static BettingMoney init() {
        return new BettingMoney(INIT_DEALER_PROFIT_VALUE);
    }

    private static void validate(final String input) {
        validatePositiveNumber(input);
        validateTenUnitsNumber(input);
    }

    private static void validatePositiveNumber(final String input) {
        if (!input.matches(POSITIVE_NUMBER_FORMAT)) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_MESSAGE);
        }
    }

    private static void validateTenUnitsNumber(final String input) {
        if (!input.matches(TEN_UNITS_NUMBER_FORMAT)) {
            throw new IllegalArgumentException(TEN_UNITS_NUMBER_MESSAGE);
        }
    }

    public BettingMoney multiplyProfit(final double rateOfReturn) {
        return new BettingMoney((int) (rateOfReturn * money));
    }

    public BettingMoney subtractBettingMoney(final BettingMoney bettingMoney) {
        return new BettingMoney(this.money - bettingMoney.money);
    }

    public int getMoney() {
        return money;
    }
}

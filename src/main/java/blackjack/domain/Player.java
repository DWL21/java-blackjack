package blackjack.domain;

import blackjack.utils.Validator;

import java.util.List;

public class Player extends Human {

    private static final String EQUALS_DEALER_NAME_MESSAGE = "딜러와 동일한 이름은 사용할 수 없습니다.";
    private static final String RECEIVED_FLAG_MESSAGE = "y, n 중에서 입력해주세요.";
    private static final String GIVEN_SYMBOL = "y";
    private static final String NOT_GIVEN_SYMBOL = "n";
    private static final String DEALER_NAME = "딜러";

    public Player(final String name) {
        super(name);
        Validator.validateNullOrEmpty(name);
        validateEqualsDealerName(name);
    }

    public boolean answer(final String receivedFlag) {
        Validator.validateNullOrEmpty(receivedFlag);
        if (receivedFlag.equalsIgnoreCase(GIVEN_SYMBOL)) {
            return true;
        }
        if (receivedFlag.equalsIgnoreCase(NOT_GIVEN_SYMBOL)) {
            return false;
        }
        throw new IllegalArgumentException(RECEIVED_FLAG_MESSAGE);
    }

    private void validateEqualsDealerName(final String name) {
        if (name.equals(DEALER_NAME)) {
            throw new IllegalArgumentException(EQUALS_DEALER_NAME_MESSAGE);
        }
    }

    @Override
    public boolean canDraw() {
        return cards.isUnderBlackjack();
    }

    public String getName() {
        return name;
    }
}

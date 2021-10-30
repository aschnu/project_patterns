package common.constant;

public enum ConsoleMessage {

    WELCOME("""
                     .__________________________________________________.
                     ||////////////////////////////////////////////////||
                     ||////////////////////////////////////////////////||
                     ||////////////////////////////////////////////////||
                     ||////////////////////////////////////////////////||    ___.
                     ||////////////////////////////////////////////////||   /    \\
                     !__________________________________________________!  |      |
                     |   __ __ __ __ __ __ __ __ __ __  /|\\ ATARI 2080ST|  |      |
                     |__/_//_//_//_//_//_//_//_//_//_/____________--____|  |  .---|---.
                     | ______________________________________________   |  |  |   |   |
                     | [][][][][][][][][][][][][][][__] [_][_] [][][][] |  |  |---'---|
                     | [_][][][][][][][][][][][][]| |[] [][][] [][][][] |  |  |       |
                     | [__][][][][][][][][][][][][__|[] [][][] [][][][] |  |  |       |
                     | [_][][][][][][][][][][][][_]            [][][]|| |  |  |  /|\\  |
                     |    [_][________________][_]             [__][]LI |  |   \\_____/
                     |__________________________________________________|  ;
                                                                      \\___/
            """),
    INPUT_CREATION_PATH("Please enter desired creation path: "),
    INPUT_WALLET("Please enter wallet type: "),
    INPUT_TRANSACTION_NUMBER("Please enter transaction number: "),
    INPUT_TRANSACTION_NAME("Please enter transaction name: "),
    INPUT_TRANSACTION_SUM("Please enter transaction sum: "),
    INPUT_TRANSACTION_DATE("Please enter transaction date: "),
    INPUT_ISSUER_ID("Please enter issuer identifier: "),
    INPUT_CARD_NAME("Please enter card name: "),
    INPUT_DEVICE_TYPE("Please enter device type: "),
    INPUT_DEVICE_VERSION("Please enter device version: "),
    INPUT_SECURITY("Please enter security: "),
    INPUT_EXCEPTION("Input exception. "),
    INPUT_PATTERN_EXCEPTION("Please use given pattern: ");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

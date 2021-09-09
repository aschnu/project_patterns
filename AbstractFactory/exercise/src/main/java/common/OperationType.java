package common;

public enum OperationType {

    INITIATE_REPERSONALIZATION("Initiate Repersonalization"),
    REPERSONALIZATION("Repersonalization"),
    RENEWAL("Renewal");

    private final String OPERATION_TYPE_NAME;

    OperationType(String operationTypeName) {

        this.OPERATION_TYPE_NAME = operationTypeName;

    }

    public String getOperationTypeName() {
        return OPERATION_TYPE_NAME;
    }

}

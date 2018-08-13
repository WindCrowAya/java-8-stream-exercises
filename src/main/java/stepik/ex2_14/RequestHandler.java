package stepik.ex2_14;

import java.util.function.Function;

@FunctionalInterface
public interface RequestHandler {

    // !!! write a method handle that accept request and returns new request here
    // it allows to use lambda expressions for creating handlers below
    Request handle(Request request);

    // !!! write a default method for combining this and other handler single one
    // the order of execution may be any but you need to consider it when composing handlers
    // the method may has any name
    default RequestHandler setSuccessor(RequestHandler other) {
        Function<RequestHandler, RequestHandler> thisHandler = (handler) -> this;
        Function<RequestHandler, RequestHandler> otherHandler = (handler) -> handler;
        return thisHandler.compose(otherHandler).apply(other);

//        UnaryOperator<RequestHandler> thisOp = (req) -> this;
//        UnaryOperator<RequestHandler> otherOp = (req) -> other;
//        Function<RequestHandler, RequestHandler> function = thisOp.andThen(otherOp);
//        return function.apply(other);
    }
}

package sal.lat.locallib.api;

import com.google.gson.JsonObject;

import java.io.IOException;

class Response {

    private JsonObject data;
    private Error error;
    private Pagination pagination;

    boolean hasData(){
        return data != null;
    }

    boolean hasError(){
        return error != null;
    }

    boolean isPaginated(){
        return pagination != null;
    }

    boolean hasNextPage(){ return isPaginated() && pagination.hasNext(); }

    String getNextPage(){ return hasNextPage() ? pagination.next : null; }

    JsonObject getData() throws IOException, LocalBitcoinsException {
        if(hasData())
            return data;
        else if(hasError())
            throw error.toException();
        else
            throw new IOException("incorrect server response");
    }

    Error getError() {
        return error;
    }

    Pagination getPagination() {
        return pagination;
    }

    static class Pagination {
        private String prev;
        private String next;

        boolean hasNext(){
            return next != null;
        }

        public String getNext() {
            return next;
        }

        public String getPrev() {
            return prev;
        }
    }

    static class Error {
        private String message;
        private int error_code;

        LocalBitcoinsException toException(){
            return new LocalBitcoinsException(message, error_code);
        }

        String getMessage(){
            return message;
        }

        int getErrorCode() {
            return error_code;
        }
    }
}

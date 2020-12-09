package id.putraprima.mygoldtracker.api.models;

public class Envelope<T> {
    String code;
    String latency;
    T data;

    public Envelope() {
    }

    public Envelope(String code, String latency, T data) {
        this.code = code;
        this.latency = latency;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLatency() {
        return latency;
    }

    public void setLatency(String latency) {
        this.latency = latency;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

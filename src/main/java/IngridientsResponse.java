import java.util.List;

public class IngridientsResponse {

    public IngridientsResponse(boolean success, List<Ingridient> data) {
        this.success = success;
        this.data = data;
    }

    private boolean success;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(List<Ingridient> data) {
        this.data = data;
    }


    public List<Ingridient> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    private List<Ingridient> data;



}

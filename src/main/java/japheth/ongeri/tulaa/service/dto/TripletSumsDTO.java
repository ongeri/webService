package japheth.ongeri.tulaa.service.dto;

import java.util.List;

public class TripletSumsDTO {
    private List<Integer> distinctIntegers;
    private int sumValue;
    private int resultCount;

    public TripletSumsDTO() {
    }

    public List<Integer> getDistinctIntegers() {
        return distinctIntegers;
    }

    public void setDistinctIntegers(List<Integer> distinctIntegers) {
        this.distinctIntegers = distinctIntegers;
    }

    public int getSumValue() {
        return sumValue;
    }

    public void setSumValue(int sumValue) {
        this.sumValue = sumValue;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }
}

package cn.it.xiaodongbei.eneity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName test_date
 */
@Data
public class TestDate implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Date datetime1;

    /**
     * 
     */
    private Date time1;

    /**
     * 
     */
    private Date date1;

    /**
     * 
     */
    private Date timestamp1;

    /**
     * 
     */
    private Object year1;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TestDate other = (TestDate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDatetime1() == null ? other.getDatetime1() == null : this.getDatetime1().equals(other.getDatetime1()))
            && (this.getTime1() == null ? other.getTime1() == null : this.getTime1().equals(other.getTime1()))
            && (this.getDate1() == null ? other.getDate1() == null : this.getDate1().equals(other.getDate1()))
            && (this.getTimestamp1() == null ? other.getTimestamp1() == null : this.getTimestamp1().equals(other.getTimestamp1()))
            && (this.getYear1() == null ? other.getYear1() == null : this.getYear1().equals(other.getYear1()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDatetime1() == null) ? 0 : getDatetime1().hashCode());
        result = prime * result + ((getTime1() == null) ? 0 : getTime1().hashCode());
        result = prime * result + ((getDate1() == null) ? 0 : getDate1().hashCode());
        result = prime * result + ((getTimestamp1() == null) ? 0 : getTimestamp1().hashCode());
        result = prime * result + ((getYear1() == null) ? 0 : getYear1().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", datetime1=").append(datetime1);
        sb.append(", time1=").append(time1);
        sb.append(", date1=").append(date1);
        sb.append(", timestamp1=").append(timestamp1);
        sb.append(", year1=").append(year1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
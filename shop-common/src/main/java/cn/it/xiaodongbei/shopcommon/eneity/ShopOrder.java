package cn.it.xiaodongbei.shopcommon.eneity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author cxc
 * @Date 2023/7/18 10:53 PM
 * @Version 1.0
 * @Description:
 */

@Data
public class ShopOrder implements Serializable {
    /**
     * 订单id
     */
    private Integer oid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 商品id
     */
    private Integer pid;

    /**
     * 商品名称
     */
    private String pname;

    /**
     * 商品单价
     */
    private Double pprice;

    /**
     * 购买数量
     */
    private Integer number;

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
        ShopOrder other = (ShopOrder) that;
        return (this.getOid() == null ? other.getOid() == null : this.getOid().equals(other.getOid()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
                && (this.getPname() == null ? other.getPname() == null : this.getPname().equals(other.getPname()))
                && (this.getPprice() == null ? other.getPprice() == null : this.getPprice().equals(other.getPprice()))
                && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOid() == null) ? 0 : getOid().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getPname() == null) ? 0 : getPname().hashCode());
        result = prime * result + ((getPprice() == null) ? 0 : getPprice().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", uid=").append(uid);
        sb.append(", username=").append(username);
        sb.append(", pid=").append(pid);
        sb.append(", pname=").append(pname);
        sb.append(", pprice=").append(pprice);
        sb.append(", number=").append(number);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}

package cn.it.xiaodongbei.shopcommon.eneity;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName shop_product
 */
@Data
public class ShopProduct implements Serializable {
    /**
     * 主键
     */
    private Integer pid;

    /**
     * 商品名称
     */
    private String pname;

    /**
     * 商品价格
     */
    private Double pprice;

    /**
     * 库存
     */
    private Integer stock;

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
        ShopProduct other = (ShopProduct) that;
        return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getPname() == null ? other.getPname() == null : this.getPname().equals(other.getPname()))
            && (this.getPprice() == null ? other.getPprice() == null : this.getPprice().equals(other.getPprice()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getPname() == null) ? 0 : getPname().hashCode());
        result = prime * result + ((getPprice() == null) ? 0 : getPprice().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", pname=").append(pname);
        sb.append(", pprice=").append(pprice);
        sb.append(", stock=").append(stock);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
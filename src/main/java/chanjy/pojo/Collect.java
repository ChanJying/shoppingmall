package chanjy.pojo;

public class Collect {

        private int id;
        private int customerId;
        private int goodsId;

        public Collect() {
        }

        public Collect(int id, int customerId, int goodsId) {
            this.id = id;
            this.customerId = customerId;
            this.goodsId = goodsId;
        }

        public Collect( int customerId, int goodsId) {
            this.customerId = customerId;
            this.goodsId = goodsId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        @Override
        public String toString() {
            return "Collect{" +
                    "id=" + id +
                    ", customerId=" + customerId +
                    ", goodsId=" + goodsId +
                    '}';
        }


}

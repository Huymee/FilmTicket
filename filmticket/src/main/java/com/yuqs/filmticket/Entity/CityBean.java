package com.yuqs.filmticket.Entity;

import java.util.List;

/**
 * Created by 46433 on 17/05/11.
 */

public class CityBean {

    /**
     * citys : {"A":[{"cityName":"阿拉尔市","id":"659006"},{"cityName":"鞍山市","id":"210300"},{"cityName":"安康市","id":"610900"},{"cityName":"安庆市","id":"340800"},{"cityName":"安顺市","id":"520400"}],"B":[{"cityName":"巴中市","id":"511900"},{"cityName":"白城市","id":"220800"},{"cityName":"白山市","id":"220600"},{"cityName":"白银市","id":"620400"},{"cityName":"百色市","id":"451000"},{"cityName":"蚌埠市","id":"340300"},{"cityName":"包头市","id":"150200"},{"cityName":"保定市","id":"130600"},{"cityName":"保山市","id":"530500"},{"cityName":"宝鸡市","id":"610300"},{"cityName":"北海市","id":"450500"},{"cityName":"北京市","id":"110100"},{"cityName":"本溪市","id":"210500"},{"cityName":"毕节市","id":"522400"},{"cityName":"滨州市","id":"371600"},{"cityName":"亳州市","id":"341600"}],"C":[{"cityName":"沧州市","id":"130900"},{"cityName":"常德市","id":"430700"},{"cityName":"常州市","id":"320400"},{"cityName":"长春市","id":"220100"},{"cityName":"长沙市","id":"430100"},{"cityName":"长治市","id":"140400"},{"cityName":"朝阳市","id":"211300"},{"cityName":"潮州市","id":"445100"},{"cityName":"巢湖市","id":"341400"},{"cityName":"郴州市","id":"431000"},{"cityName":"成都市","id":"510100"},{"cityName":"承德市","id":"130800"},{"cityName":"池州市","id":"341700"},{"cityName":"赤峰市","id":"150400"},{"cityName":"崇左市","id":"451400"},{"cityName":"滁州市","id":"341100"},{"cityName":"重庆市","id":"500100"}],"D":[{"cityName":"达州市","id":"511700"},{"cityName":"大理白族自治州","id":"532900"},{"cityName":"大连市","id":"210200"},{"cityName":"大庆市","id":"230600"},{"cityName":"大同市","id":"140200"},{"cityName":"丹东市","id":"210600"},{"cityName":"德阳市","id":"510600"},{"cityName":"德州市","id":"371400"},{"cityName":"定西市","id":"621100"},{"cityName":"东营市","id":"370500"},{"cityName":"东莞市","id":"441900"}],"E":[{"cityName":"鄂尔多斯市","id":"150600"},{"cityName":"鄂州市","id":"420700"},{"cityName":"恩施土家族苗族自治州","id":"422800"}],"F":[{"cityName":"防城港市","id":"450600"},{"cityName":"佛山市","id":"440600"},{"cityName":"福州市","id":"350100"},{"cityName":"抚顺市","id":"210400"},{"cityName":"抚州市","id":"361000"},{"cityName":"阜新市","id":"210900"},{"cityName":"阜阳市","id":"341200"}],"G":[{"cityName":"赣州市","id":"360700"},{"cityName":"广安市","id":"511600"},{"cityName":"广元市","id":"510800"},{"cityName":"广州市","id":"440100"},{"cityName":"桂林市","id":"450300"},{"cityName":"贵港市","id":"450800"},{"cityName":"贵阳市","id":"520100"}],"H":[{"cityName":"哈尔滨市","id":"230100"},{"cityName":"海口市","id":"460100"},{"cityName":"邯郸市","id":"130400"},{"cityName":"汉中市","id":"610700"},{"cityName":"杭州市","id":"330100"},{"cityName":"菏泽市","id":"371700"},{"cityName":"合肥市","id":"340100"},{"cityName":"河源市","id":"441600"},{"cityName":"鹤壁市","id":"410600"},{"cityName":"鹤岗市","id":"230400"},{"cityName":"贺州市","id":"451100"},{"cityName":"黑河市","id":"231100"},{"cityName":"衡水市","id":"131100"},{"cityName":"红河哈尼族彝族自治州","id":"532500"},{"cityName":"呼和浩特市","id":"150100"},{"cityName":"葫芦岛市","id":"211400"},{"cityName":"湖州市","id":"330500"},{"cityName":"化州市","id":"445500"},{"cityName":"怀化市","id":"431200"},{"cityName":"淮安市","id":"320800"},{"cityName":"淮南市","id":"340400"},{"cityName":"黄冈市","id":"421100"},{"cityName":"黄山市","id":"341000"},{"cityName":"黄石市","id":"420200"},{"cityName":"惠州市","id":"441300"}],"I":[],"J":[{"cityName":"鸡西市","id":"230300"},{"cityName":"吉安市","id":"360800"},{"cityName":"吉林市","id":"220200"},{"cityName":"济南市","id":"370100"},{"cityName":"济宁市","id":"370800"},{"cityName":"济源市","id":"411800"},{"cityName":"嘉兴市","id":"330400"},{"cityName":"嘉峪关市","id":"620200"},{"cityName":"佳木斯市","id":"230800"},{"cityName":"建德","id":"659042"},{"cityName":"江门市","id":"440700"},{"cityName":"焦作市","id":"410800"},{"cityName":"揭阳市","id":"445200"},{"cityName":"金华市","id":"330700"},{"cityName":"锦州市","id":"210700"},{"cityName":"晋城市","id":"140500"},{"cityName":"晋中市","id":"140700"},{"cityName":"荆门市","id":"420800"},{"cityName":"荆州市","id":"421000"},{"cityName":"九江市","id":"360400"},{"cityName":"酒泉市","id":"620900"},{"cityName":"句容市","id":"659019"}],"K":[{"cityName":"开封市","id":"410200"},{"cityName":"昆明市","id":"530100"}],"L":[{"cityName":"来宾市","id":"451300"},{"cityName":"兰州市","id":"620100"},{"cityName":"廊坊市","id":"131000"},{"cityName":"乐山市","id":"511100"},{"cityName":"丽水市","id":"331100"},{"cityName":"连云港市","id":"320700"},{"cityName":"聊城市","id":"371500"},{"cityName":"辽阳市","id":"211000"},{"cityName":"辽源市","id":"220400"},{"cityName":"临沧市","id":"530900"},{"cityName":"临汾市","id":"141000"},{"cityName":"临沂市","id":"371300"},{"cityName":"柳州市","id":"450200"},{"cityName":"六安市","id":"341500"},{"cityName":"六盘水市","id":"520200"},{"cityName":"龙岩市","id":"350800"},{"cityName":"娄底市","id":"431300"},{"cityName":"吕梁市","id":"141100"},{"cityName":"洛阳市","id":"410300"},{"cityName":"阆中市","id":"513500"},{"cityName":"泸州市","id":"510500"},{"cityName":"漯河市","id":"411100"}],"M":[{"cityName":"马鞍山市","id":"340500"},{"cityName":"茂名市","id":"440900"},{"cityName":"梅州市","id":"441400"},{"cityName":"眉山市","id":"511400"},{"cityName":"绵阳市","id":"510700"},{"cityName":"牡丹江市","id":"231000"}],"N":[{"cityName":"南昌市","id":"360100"},{"cityName":"南充市","id":"511300"},{"cityName":"南京市","id":"320100"},{"cityName":"南宁市","id":"450100"},{"cityName":"南平市","id":"350700"},{"cityName":"南通市","id":"320600"},{"cityName":"南阳市","id":"411300"},{"cityName":"内江市","id":"511000"},{"cityName":"宁波市","id":"330200"},{"cityName":"宁德市","id":"350900"}],"O":[],"P":[{"cityName":"盘锦市","id":"211100"},{"cityName":"萍乡市","id":"360300"},{"cityName":"平凉市","id":"620800"},{"cityName":"莆田市","id":"350300"},{"cityName":"濮阳市","id":"410900"}],"Q":[{"cityName":"七台河市","id":"230900"},{"cityName":"齐齐哈尔市","id":"230200"},{"cityName":"黔东南苗族侗族自治州","id":"522600"},{"cityName":"黔南布依族苗族自治州","id":"522700"},{"cityName":"潜江市","id":"659003"},{"cityName":"钦州市","id":"450700"},{"cityName":"秦皇岛市","id":"130300"},{"cityName":"青岛市","id":"370200"},{"cityName":"清远市","id":"441800"},{"cityName":"曲靖市","id":"530300"},{"cityName":"泉州市","id":"350500"},{"cityName":"衢州市","id":"330800"}],"R":[{"cityName":"日照市","id":"371100"}],"S":[{"cityName":"三门峡市","id":"411200"},{"cityName":"三明市","id":"350400"},{"cityName":"三亚市","id":"460200"},{"cityName":"汕头市","id":"440500"},{"cityName":"汕尾市","id":"441500"},{"cityName":"商洛市","id":"611000"},{"cityName":"商丘市","id":"411400"},{"cityName":"上海市","id":"310100"},{"cityName":"上饶市","id":"361100"},{"cityName":"韶关市","id":"440200"},{"cityName":"邵阳市","id":"430500"},{"cityName":"绍兴市","id":"330600"},{"cityName":"深圳市","id":"440300"},{"cityName":"沈阳市","id":"210100"},{"cityName":"十堰市","id":"420300"},{"cityName":"石家庄市","id":"130100"},{"cityName":"石嘴山市","id":"640200"},{"cityName":"双鸭山市","id":"230500"},{"cityName":"朔州市","id":"140600"},{"cityName":"思茅市","id":"530800"},{"cityName":"四平市","id":"220300"},{"cityName":"松原市","id":"220700"},{"cityName":"苏州市","id":"320500"},{"cityName":"宿迁市","id":"321300"},{"cityName":"宿州市","id":"341300"},{"cityName":"随州市","id":"421300"},{"cityName":"绥化市","id":"231200"},{"cityName":"遂宁市","id":"510900"}],"T":[{"cityName":"台州市","id":"331000"},{"cityName":"泰安市","id":"370900"},{"cityName":"泰州市","id":"321200"},{"cityName":"太原市","id":"140100"},{"cityName":"唐山市","id":"130200"},{"cityName":"天津市","id":"120100"},{"cityName":"天门市","id":"659002"},{"cityName":"天水市","id":"620500"},{"cityName":"铁岭市","id":"211200"},{"cityName":"通化市","id":"220500"},{"cityName":"通辽市","id":"150500"},{"cityName":"铜川市","id":"610200"},{"cityName":"铜陵市","id":"340700"},{"cityName":"铜仁市","id":"522200"}],"U":[],"V":[],"W":[{"cityName":"威海市","id":"371000"},{"cityName":"潍坊市","id":"370700"},{"cityName":"渭南市","id":"610500"},{"cityName":"温州市","id":"330300"},{"cityName":"文山壮族苗族自治州","id":"532600"},{"cityName":"乌海市","id":"150300"},{"cityName":"乌兰察布市","id":"150900"},{"cityName":"无锡市","id":"320200"},{"cityName":"芜湖市","id":"340200"},{"cityName":"梧州市","id":"450400"},{"cityName":"武汉市","id":"420100"}],"X":[{"cityName":"西安市","id":"610100"},{"cityName":"西宁市","id":"630100"},{"cityName":"锡林郭勒盟","id":"152500"},{"cityName":"厦门市","id":"350200"},{"cityName":"仙桃市","id":"659001"},{"cityName":"咸宁市","id":"421200"},{"cityName":"咸阳市","id":"610400"},{"cityName":"襄阳市","id":"420600"},{"cityName":"湘潭市","id":"430300"},{"cityName":"湘西土家族苗族自治州","id":"433100"},{"cityName":"孝感市","id":"420900"},{"cityName":"新乡市","id":"410700"},{"cityName":"新余市","id":"360500"},{"cityName":"忻州市","id":"140900"},{"cityName":"信阳市","id":"411500"},{"cityName":"兴城市","id":"211500"},{"cityName":"邢台市","id":"130500"},{"cityName":"徐州市","id":"320300"},{"cityName":"许昌市","id":"411000"}],"Y":[{"cityName":"烟台市","id":"370600"},{"cityName":"盐城市","id":"320900"},{"cityName":"延安市","id":"610600"},{"cityName":"延边朝鲜族自治州","id":"222400"},{"cityName":"扬州市","id":"321000"},{"cityName":"阳江市","id":"441700"},{"cityName":"阳泉市","id":"140300"},{"cityName":"伊春市","id":"230700"},{"cityName":"宜宾市","id":"511500"},{"cityName":"宜昌市","id":"420500"},{"cityName":"宜春市","id":"360900"},{"cityName":"益阳市","id":"430900"},{"cityName":"银川市","id":"640100"},{"cityName":"鹰潭市","id":"360600"},{"cityName":"营口市","id":"210800"},{"cityName":"永州市","id":"431100"},{"cityName":"榆林市","id":"610800"},{"cityName":"玉林市","id":"450900"},{"cityName":"玉溪市","id":"530400"},{"cityName":"岳阳市","id":"430600"},{"cityName":"运城市","id":"140800"}],"Z":[{"cityName":"枣庄市","id":"370400"},{"cityName":"湛江市","id":"440800"},{"cityName":"漳州市","id":"350600"},{"cityName":"张家口市","id":"130700"},{"cityName":"张掖市","id":"620700"},{"cityName":"昭通市","id":"530600"},{"cityName":"肇庆市","id":"441200"},{"cityName":"镇江市","id":"321100"},{"cityName":"郑州市","id":"410100"},{"cityName":"中山市","id":"442000"},{"cityName":"中卫市","id":"640500"},{"cityName":"舟山市","id":"330900"},{"cityName":"周口市","id":"411600"},{"cityName":"珠海市","id":"440400"},{"cityName":"株洲市","id":"430200"},{"cityName":"驻马店市","id":"411700"},{"cityName":"资阳市","id":"512000"},{"cityName":"淄博市","id":"370300"},{"cityName":"自贡市","id":"510300"},{"cityName":"遵义市","id":"520300"}]}
     * status : ok
     */

    private CitysBean citys;
    private String status;

    public CitysBean getCitys() {
        return citys;
    }

    public void setCitys(CitysBean citys) {
        this.citys = citys;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class CitysBean {
        private List<City> A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;

        public List<City> getA() {
            return A;
        }

        public void setA(List<City> A) {
            this.A = A;
        }

        public List<City> getB() {
            return B;
        }

        public void setB(List<City> B) {
            this.B = B;
        }

        public List<City> getC() {
            return C;
        }

        public void setC(List<City> C) {
            this.C = C;
        }

        public List<City> getD() {
            return D;
        }

        public void setD(List<City> D) {
            this.D = D;
        }

        public List<City> getE() {
            return E;
        }

        public void setE(List<City> E) {
            this.E = E;
        }

        public List<City> getF() {
            return F;
        }

        public void setF(List<City> F) {
            this.F = F;
        }

        public List<City> getG() {
            return G;
        }

        public void setG(List<City> G) {
            this.G = G;
        }

        public List<City> getH() {
            return H;
        }

        public void setH(List<City> H) {
            this.H = H;
        }

        public List<City> getI() {
            return I;
        }

        public void setI(List<City> I) {
            this.I = I;
        }

        public List<City> getJ() {
            return J;
        }

        public void setJ(List<City> J) {
            this.J = J;
        }

        public List<City> getK() {
            return K;
        }

        public void setK(List<City> K) {
            this.K = K;
        }

        public List<City> getL() {
            return L;
        }

        public void setL(List<City> L) {
            this.L = L;
        }

        public List<City> getM() {
            return M;
        }

        public void setM(List<City> M) {
            this.M = M;
        }

        public List<City> getN() {
            return N;
        }

        public void setN(List<City> N) {
            this.N = N;
        }

        public List<City> getO() {
            return O;
        }

        public void setO(List<City> O) {
            this.O = O;
        }

        public List<City> getP() {
            return P;
        }

        public void setP(List<City> P) {
            this.P = P;
        }

        public List<City> getQ() {
            return Q;
        }

        public void setQ(List<City> Q) {
            this.Q = Q;
        }

        public List<City> getR() {
            return R;
        }

        public void setR(List<City> R) {
            this.R = R;
        }

        public List<City> getS() {
            return S;
        }

        public void setS(List<City> S) {
            this.S = S;
        }

        public List<City> getT() {
            return T;
        }

        public void setT(List<City> T) {
            this.T = T;
        }

        public List<City> getU() {
            return U;
        }

        public void setU(List<City> U) {
            this.U = U;
        }

        public List<City> getV() {
            return V;
        }

        public void setV(List<City> V) {
            this.V = V;
        }

        public List<City> getW() {
            return W;
        }

        public void setW(List<City> W) {
            this.W = W;
        }

        public List<City> getX() {
            return X;
        }

        public void setX(List<City> X) {
            this.X = X;
        }

        public List<City> getY() {
            return Y;
        }

        public void setY(List<City> Y) {
            this.Y = Y;
        }

        public List<City> getZ() {
            return Z;
        }

        public void setZ(List<City> Z) {
            this.Z = Z;
        }

        public static class City {
            /**
             * cityName : 阿拉尔市
             * id : 659006
             */

            private String cityName;
            private String id;

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}

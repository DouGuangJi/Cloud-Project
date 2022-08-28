package cn.riest.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;


/**
 * <p>
 * 租户--采集--终端设备自动采集表--电流电量电压功率--最新值
 * </p>
 *
 * @author dgj
 * @since 2021-09-23
 */
public class PowerAutogatherterminalnewest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 添加人ID
     */
    private Long auserid;

    /**
     * 添加人姓名
     */
    private String ausername;

    /**
     * 添加时间
     */
    private LocalDateTime atime;

    /**
     * 添加人类型
     */
    private Long autype;

    /**
     * 修改人ID
     */
    private Long muserid;

    /**
     * 修改人姓名
     */
    private String musername;

    /**
     * 修改时间
     */
    private LocalDateTime mtime;

    /**
     * 修改人类型
     */
    private Long mutype;

    /**
     * 租户ID
     */
    private Long tenantid;

    /**
     * 租户名称
     */
    private String tenantname;

    /**
     * 添加人机构id
     */
    private Long aorgid;

    /**
     * 添加人机构名称
     */
    private String aorgname;

    /**
     * 添加人层级
     */
    private Long auserlevel;

    /**
     * 添加人上级机构层级
     */
    private String aorglink;

    /**
     * 添加人上级机构名称层级
     */
    private String aorgnamelink;

    /**
     * 控制器：设备ID
     */
    private Long condevid;

    /**
     * 控制器：序列号SN
     */
    private String condevsn;

    /**
     * 控制器：注册码
     */
    private String conregcode;

    /**
     * 终端：设备ID
     */
    private Long termdevid;

    /**
     * 终端匹配码
     */
    private Long matchcode;

    /**
     * 当前电压V小数1位
     */
    private BigDecimal voltagenow;

    /**
     * 当前电流MA小数0位
     */
    private BigDecimal elecnow;

    /**
     * 当前功率W小数1位
     */
    private BigDecimal kwhnow;

    /**
     * 当前读取的电量数值-度小数3位
     */
    private BigDecimal powernow;

    /**
     * 上一条电流MA小数0位
     */
    private BigDecimal lastelec;

    /**
     * 上一条电量读取值
     */
    private BigDecimal lastpower;

    /**
     * 上一条数据到现在耗费的电量值
     */
    private BigDecimal usepower;

    /**
     * 漏电mA小数0位
     */
    private BigDecimal leakage;

    /**
     * 子设备id
     */
    private String childdevid;

    /**
     * 设备类型(1:主设备101:子设备)
     */
    private Long childdevtype;

    /**
     * 设备数据上传时间(时间戳)
     */
    private String devtime;

    public Long getAuserid() {
        return auserid;
    }

    public void setAuserid(Long auserid) {
        this.auserid = auserid;
    }

    public String getAusername() {
        return ausername;
    }

    public void setAusername(String ausername) {
        this.ausername = ausername;
    }

    public LocalDateTime getAtime() {
        return atime;
    }

    public void setAtime(LocalDateTime atime) {
        this.atime = atime;
    }

    public Long getAutype() {
        return autype;
    }

    public void setAutype(Long autype) {
        this.autype = autype;
    }

    public Long getMuserid() {
        return muserid;
    }

    public void setMuserid(Long muserid) {
        this.muserid = muserid;
    }

    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername;
    }

    public LocalDateTime getMtime() {
        return mtime;
    }

    public void setMtime(LocalDateTime mtime) {
        this.mtime = mtime;
    }

    public Long getMutype() {
        return mutype;
    }

    public void setMutype(Long mutype) {
        this.mutype = mutype;
    }

    public Long getTenantid() {
        return tenantid;
    }

    public void setTenantid(Long tenantid) {
        this.tenantid = tenantid;
    }

    public String getTenantname() {
        return tenantname;
    }

    public void setTenantname(String tenantname) {
        this.tenantname = tenantname;
    }

    public Long getAorgid() {
        return aorgid;
    }

    public void setAorgid(Long aorgid) {
        this.aorgid = aorgid;
    }

    public String getAorgname() {
        return aorgname;
    }

    public void setAorgname(String aorgname) {
        this.aorgname = aorgname;
    }

    public Long getAuserlevel() {
        return auserlevel;
    }

    public void setAuserlevel(Long auserlevel) {
        this.auserlevel = auserlevel;
    }

    public String getAorglink() {
        return aorglink;
    }

    public void setAorglink(String aorglink) {
        this.aorglink = aorglink;
    }

    public String getAorgnamelink() {
        return aorgnamelink;
    }

    public void setAorgnamelink(String aorgnamelink) {
        this.aorgnamelink = aorgnamelink;
    }

    public Long getCondevid() {
        return condevid;
    }

    public void setCondevid(Long condevid) {
        this.condevid = condevid;
    }

    public String getCondevsn() {
        return condevsn;
    }

    public void setCondevsn(String condevsn) {
        this.condevsn = condevsn;
    }

    public String getConregcode() {
        return conregcode;
    }

    public void setConregcode(String conregcode) {
        this.conregcode = conregcode;
    }

    public Long getTermdevid() {
        return termdevid;
    }

    public void setTermdevid(Long termdevid) {
        this.termdevid = termdevid;
    }

    public Long getMatchcode() {
        return matchcode;
    }

    public void setMatchcode(Long matchcode) {
        this.matchcode = matchcode;
    }

    public BigDecimal getVoltagenow() {
        return voltagenow;
    }

    public void setVoltagenow(BigDecimal voltagenow) {
        this.voltagenow = voltagenow;
    }

    public BigDecimal getElecnow() {
        return elecnow;
    }

    public void setElecnow(BigDecimal elecnow) {
        this.elecnow = elecnow;
    }

    public BigDecimal getKwhnow() {
        return kwhnow;
    }

    public void setKwhnow(BigDecimal kwhnow) {
        this.kwhnow = kwhnow;
    }

    public BigDecimal getPowernow() {
        return powernow;
    }

    public void setPowernow(BigDecimal powernow) {
        this.powernow = powernow;
    }

    public BigDecimal getLastelec() {
        return lastelec;
    }

    public void setLastelec(BigDecimal lastelec) {
        this.lastelec = lastelec;
    }

    public BigDecimal getLastpower() {
        return lastpower;
    }

    public void setLastpower(BigDecimal lastpower) {
        this.lastpower = lastpower;
    }

    public BigDecimal getUsepower() {
        return usepower;
    }

    public void setUsepower(BigDecimal usepower) {
        this.usepower = usepower;
    }

    public BigDecimal getLeakage() {
        return leakage;
    }

    public void setLeakage(BigDecimal leakage) {
        this.leakage = leakage;
    }

    public String getChilddevid() {
        return childdevid;
    }

    public void setChilddevid(String childdevid) {
        this.childdevid = childdevid;
    }

    public Long getChilddevtype() {
        return childdevtype;
    }

    public void setChilddevtype(Long childdevtype) {
        this.childdevtype = childdevtype;
    }

    public String getDevtime() {
        return devtime;
    }

    public void setDevtime(String devtime) {
        this.devtime = devtime;
    }
}

package cn.riest.entity;

import java.time.LocalDateTime;
import java.io.Serializable;


/**
 * <p>
 * 租户--采集--终端设备自动采集表--开关--最新值
 * </p>
 *
 * @author dgj
 * @since 2021-09-24
 */

public class PowerAutogatheropenclosenewest implements Serializable {

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
     * 控制器ID
     */
    private Long condevid;

    /**
     * 序列号SN
     */
    private String condevsn;

    /**
     * 注册码
     */
    private String conregcode;

    /**
     * 终端设备ID
     */
    private Long termdevid;

    /**
     * 终端匹配码
     */
    private Long matchcode;

    /**
     * 开关状态
     */
    private Long openclose;

    /**
     * 上一条时间
     */
    private LocalDateTime pretime;

    /**
     * 上一条开关状态
     */
    private Long preopenclose;

    /**
     * 子设备id
     */
    private String childdevid;

    /**
     * 设备类型(1:主设备101:子设备)
     */
    private Long childdevtype;


}

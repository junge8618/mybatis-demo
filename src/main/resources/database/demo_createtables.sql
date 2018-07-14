/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2018-07-14 15:15:03                          */
/*==============================================================*/


drop table t_demo_brand;

drop table t_demo_goodsinfo;

drop sequence SEQ_DEMO_BRAND;

drop sequence SEQ_DEMO_GOODS;

create sequence SEQ_DEMO_BRAND;

create sequence SEQ_DEMO_GOODS;

/*==============================================================*/
/* Table: t_demo_brand                                          */
/*==============================================================*/
create table t_demo_brand (
   brandid              INT8                 not null default nextval('SEQ_DEMO_BRAND'),
   brandname            VARCHAR(64)          not null,
   vendername           VARCHAR(32)          null,
   constraint PK_T_DEMO_BRAND primary key (brandid)
);

comment on table t_demo_brand is
'品牌表';

comment on column t_demo_brand.brandid is
'品牌ID';

comment on column t_demo_brand.brandname is
'品牌名称';

comment on column t_demo_brand.vendername is
'厂商名称';

/*==============================================================*/
/* Table: t_demo_goodsinfo                                      */
/*==============================================================*/
create table t_demo_goodsinfo (
   goodsid              INT8                 not null default nextval('SEQ_DEMO_GOODS'),
   goodsname            VARCHAR(64)          not null,
   barcode              VARCHAR(32)          null,
   price                DECIMAL(12,2)        not null default 0,
   unitname             VARCHAR(32)          null,
   color                VARCHAR(32)          not null,
   brandid              INT4                 null,
   constraint PK_T_DEMO_GOODSINFO primary key (goodsid)
);

comment on table t_demo_goodsinfo is
'商品表';

comment on column t_demo_goodsinfo.goodsid is
'活动ID';

comment on column t_demo_goodsinfo.goodsname is
'商品名称';

comment on column t_demo_goodsinfo.barcode is
'商品条码';

comment on column t_demo_goodsinfo.price is
'商品价格';

comment on column t_demo_goodsinfo.unitname is
'单位';

comment on column t_demo_goodsinfo.color is
'颜色';


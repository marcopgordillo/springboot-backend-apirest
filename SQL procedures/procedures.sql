CREATE OR REPLACE VIEW factura_items_subtotal AS
select fi.factura_id, fi.cantidad * p.precio as subtotal from facturas_items fi left join productos p on fi.producto_id = p.id;

DROP PROCEDURE IF EXISTS factura_total;

DELIMITER $$
CREATE PROCEDURE factura_total(
  IN factura_id INTEGER,
  OUT total DOUBLE)
BEGIN
  select SUM(subtotal) into total from (SELECT fis.subtotal FROM factura_items_subtotal as fis where fis.factura_id=factura_id) as subtable;
END $$
DELIMITER ;

call factura_total(2, @total);
select @total as TOTAL;

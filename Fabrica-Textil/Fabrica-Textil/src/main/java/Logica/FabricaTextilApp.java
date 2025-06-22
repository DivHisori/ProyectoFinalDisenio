
package Logica;


import java.util.*;

public class FabricaTextilApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Trabajador> trabajadores = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        List<OrdenVenta> ordenes = new ArrayList<>();
        List<Lote> lotes = new ArrayList<>();
        int contadorOrden = 1001;
        int contadorLote = 5001;

        while (true) {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Ingresar como ADMINISTRADOR");
            System.out.println("2. Ingresar como EMPLEADO");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int rol = scanner.nextInt();
            scanner.nextLine();

            switch (rol) {
                case 1:
                    boolean salirAdmin = false;
                    while (!salirAdmin) {
                        System.out.println("--- MENU ADMINISTRADOR ---");
                        System.out.println("1. Registrar nuevo operario");
                        System.out.println("2. Registrar materia prima");
                        System.out.println("3. Volver");
                        System.out.print("Seleccione una opcion: ");
                        int opcionAdmin = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionAdmin) {
                            case 1:
                                System.out.print("Ingrese ID del operario: ");
                                int id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Ingrese nombre del operario: ");
                                String nombre = scanner.nextLine();
                                trabajadores.add(new Operario(id, nombre));
                                System.out.println("Operario registrado.");
                                break;
                            case 2:
                                System.out.print("Ingrese tipo de materia prima: ");
                                String tipo = scanner.nextLine();
                                System.out.print("Ingrese cantidad: ");
                                int cantidad = scanner.nextInt();
                                System.out.print("Ingrese precio por unidad: ");
                                double precio = scanner.nextDouble();
                                scanner.nextLine();
                                productos.add(new MateriaPrima(tipo, cantidad, precio));
                                System.out.println("Materia prima registrada.");
                                break;
                            case 3:
                                salirAdmin = true;
                                break;
                            default:
                                System.out.println("Opcion invalida.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("--- SELECCION DE SECTOR ---");
                    System.out.println("1. Almacenamiento");
                    System.out.println("2. Ventas");
                    System.out.print("Seleccione el sector: ");
                    int sector = scanner.nextInt();
                    scanner.nextLine();

                    if (sector == 1) {
                        boolean salirAlmacen = false;
                        while (!salirAlmacen) {
                            System.out.println("--- MENU ALMACENAMIENTO ---");
                            System.out.println("1. Crear lote");
                            System.out.println("2. Procesar lotes");
                            System.out.println("3. Volver");
                            System.out.print("Seleccione una opcion: ");
                            int opcion = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcion) {
                                case 1:
                                    if (trabajadores.isEmpty() || productos.isEmpty()) {
                                        System.out.println("Debe registrar al menos un operario y una materia prima.");
                                        break;
                                    }
                                    System.out.println("Seleccione un operario:");
                                    for (int i = 0; i < trabajadores.size(); i++) {
                                        System.out.println((i + 1) + ". " + trabajadores.get(i));
                                    }
                                    int idxTrab = scanner.nextInt() - 1;

                                    System.out.println("Seleccione una materia prima:");
                                    for (int i = 0; i < productos.size(); i++) {
                                        System.out.println((i + 1) + ". " + productos.get(i).describir());
                                    }
                                    int idxProd = scanner.nextInt() - 1;

                                    Lote lote = new Lote(contadorLote++, trabajadores.get(idxTrab), productos.get(idxProd));
                                    lotes.add(lote);
                                    System.out.println("Lote creado.");
                                    break;

                                case 2:
                                    if (lotes.isEmpty()) {
                                        System.out.println("No hay lotes pendientes.");
                                        break;
                                    }
                                    for (Lote l : lotes) {
                                        l.procesarLote();
                                    }
                                    lotes.clear();
                                    break;

                                case 3:
                                    salirAlmacen = true;
                                    break;

                                default:
                                    System.out.println("Opcion invalida.");
                            }
                        }
                    } else if (sector == 2) {
                        boolean salirVentas = false;
                        while (!salirVentas) {
                            System.out.println("\n--- MENU VENTAS ---");
                            System.out.println("1. Crear orden de produccion");
                            System.out.println("2. Ver detalles de compras");
                            System.out.println("3. Volver");
                            System.out.print("Seleccione una opcion: ");
                            int opcion = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcion) {
                                case 1:
                                    if (trabajadores.isEmpty() || productos.isEmpty()) {
                                        System.out.println("Debe registrar operarios y productos primero.");
                                        break;
                                    }
                                    System.out.print("Ingrese nombre del cliente: ");
                                    String cliente = scanner.nextLine();
                                    System.out.print("Tipo de venta: (mayor/menor): ");
                                    String tipoVenta = scanner.nextLine().toLowerCase();

                                    System.out.println("Seleccione un operario:");
                                    for (int i = 0; i < trabajadores.size(); i++) {
                                        System.out.println((i + 1) + ". " + trabajadores.get(i));
                                    }
                                    int idxOperario = scanner.nextInt() - 1;

                                    System.out.println("Seleccione una materia prima:");
                                    for (int i = 0; i < productos.size(); i++) {
                                        System.out.println((i + 1) + ". " + productos.get(i).describir());
                                    }
                                    int idxProducto = scanner.nextInt() - 1;

                                    MateriaPrima producto = (MateriaPrima) productos.get(idxProducto);
                                    double base = producto.getPrecioUnitario();
                                    double precioFinal;

                                    if (tipoVenta.equals("mayor")) {
                                        precioFinal = (base + 0.0005 * base) - 0.005 * base;
                                    } else {
                                        precioFinal = base + 0.005 * base;
                                    }

                                    OrdenVenta orden = new OrdenVenta(
                                            contadorOrden++,
                                            trabajadores.get(idxOperario),
                                            producto,
                                            cliente,
                                            tipoVenta,
                                            Math.round(precioFinal * 100.0) / 100.0
                                    );
                                    ordenes.add(orden);
                                    System.out.println("Orden de venta creada.");
                                    break;

                                case 2:
                                    if (ordenes.isEmpty()) {
                                        System.out.println("No hay compras registradas.");
                                        break;
                                    }
                                    System.out.println("--- DETALLES DE COMPRAS ---");
                                    for (OrdenVenta o : ordenes) {
                                        System.out.println("Cliente: " + o.getCliente());
                                        System.out.println("Tipo de venta: " + o.getTipoVenta());
                                        System.out.println(o.getProducto().describir());
                                        System.out.println("Precio unitario final: S/. " + o.getPrecioFinal());
                                        System.out.println("------------------------------");
                                    }
                                    break;

                                case 3:
                                    salirVentas = true;
                                    break;

                                default:
                                    System.out.println("Opcion invalida.");
                            }
                        }
                    } else {
                        System.out.println("Sector invalido.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }
}

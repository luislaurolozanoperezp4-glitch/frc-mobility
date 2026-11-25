# FRC Mobility Starter (Java, WPILib 2026)

Base de robot FRC con drivetrain diferencial, intake, indexer, controles de operador y autónomo de avance por tiempo. Los motores PWM son ejemplos de arranque, no una configuración universal.

## Hardware de ejemplo
- 2 motores de drivetrain en PWM 0 y 1
- Motor de intake PWM 2
- Motor de indexer PWM 3
- Controladores Xbox en puertos USB 0 (driver) y 1 (operator)

Cambia los puertos, inversión, tipo de controlador y límites en `Constants.java` y en cada subsistema antes de conectar al robot. Para mecanismos reales se recomienda añadir sensores, límites físicos, corriente y parada segura.

## Controles
- Driver: sticks izquierdos para avanzar/girar; bumper izquierdo intake, derecho reversa
- Operador: A indexer adelante, B reversa, X intake + indexer
- Autónomo: avance a velocidad fija durante 2 s (solo demo; valida espacio y seguridad antes de desplegar)

## Abrir y desplegar
Abre la carpeta en WPILib VS Code 2026, configura el número de equipo en `wpilib_preferences.json` o con WPILib: Set Team Number y despliega con WPILib: Deploy Robot Code. Verifica primero sin ruedas en el piso.

Este starter no conoce la geometría, CAN IDs, controladores ni sensores del robot del equipo. Ajusta la configuración tras confirmar el cableado y el diseño mecánico.

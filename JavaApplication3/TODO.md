# TODO: Fix Partida Registration Issues

## Issues Identified

- The registration panel allows submitting with empty fields or invalid date ("No se").
- All fields should be mandatory.
- The `registrarPartida()` method only uses data from Equipo 1, ignoring Equipo 2 and other fields like kills, deaths, assists.
- Date validation is missing.

## Plan

1. **Update InterfazEsports.registrarPartida()**: ✅ COMPLETED

   - Retrieve and validate all fields from both Equipo 1 and Equipo 2.
   - Ensure no fields are empty.
   - Validate date format (e.g., dd/mm/yyyy) and prevent "No se".
   - Since the model doesn't use kills/deaths/assists, validate their presence but note they are not processed yet.
   - Added validation for kills, deaths, assists to have more than one digit.

2. **Update PanelRegistroPartida.limpiarCampos()**: ✅ COMPLETED

   - Clear all text fields after successful registration.
   - Reset combo boxes to first item.

3. **Update Tests**: ✅ COMPLETED
   - Added test in DirectorEquipoTest for validation of kills/deaths/assists having more than one digit.

## Dependent Files

- `src/umariana/cupi2/esports/interfaz/InterfazEsports.java` ✅ UPDATED
- `src/umariana/cupi2/esports/interfaz/PanelRegistroPartida.java` ✅ UPDATED
- `test/umariana/cupi2/esports/test/DirectorEquipoTest.java` ✅ UPDATED (add new tests)

## Followup Steps

- Run the application and test the registration panel.
- Verify error messages for invalid inputs.
- Run unit tests to ensure validations work.
- If needed, extend the model to handle kills/deaths/assists in future updates.

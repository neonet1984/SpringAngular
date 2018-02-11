export function actionsErrorForm(error) {
  if (error.status = '401') {
    return  'INVALIDINPUTDATA';
  }
  return  'ERRORREQUEST';
}

export function actionsError(error) {

}

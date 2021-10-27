const PROXY = [{
  context: [
    '/api'
  ],
  target: 'http://localhost:8080/login',
  secure: false,
  logLevel: 'debug',
  pathRewrite : {
    '^/api': '',
  }
  
}]
module.exports  = PROXY;
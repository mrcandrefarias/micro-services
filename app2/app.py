import json
from time import sleep

import requests
from flask import Flask
app = Flask(__name__)

BASE_CONSUL_URL = 'http://consul1:8500'

PORT = 80


@app.route('/health')
def health():
    return json.dumps(
        { 'status': 'healthy'}
    )

@app.route('/app')
def hello_world():
    return json.dumps(
            { 'Ola': 'PythonApp 02'}
    )

def register():
    url = BASE_CONSUL_URL + '/v1/agent/service/register'
    data = {
        'name': 'app2',
        'address': 'app2',
        "Port": PORT,
        'check': {
            'http': 'http://app2:{port}/health'.format(port=PORT),
            'interval': '10s'
        }
    }
    
    res = requests.put(
        url,
        data=json.dumps(data)
    )
    return res.text


if __name__ == '__main__':
    sleep(8)
    try:
        print(register())
    except:
        pass
    app.debug = True
    app.run(host="0.0.0.0", port=PORT)

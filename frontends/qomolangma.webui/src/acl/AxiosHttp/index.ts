import axios, {AxiosInstance, AxiosRequestConfig, AxiosResponse} from "axios";
import makeSingleton from "../../frameworks/makeSingleton";

export class AxiosHttp {
    private readonly impl: AxiosInstance

    public constructor() {
        this.impl = axios.create({
            timeout: 10 * 1000
        });
    }

    public async get(url: string, requestUrl: string, options?: AxiosRequestConfig) {
        const response = await this.impl.get(
            url,
            Object.assign(options || {}, {baseURL: requestUrl})
        );
        return this.response(response)
    }

    public async post(url: string, requestUrl: string, options: AxiosRequestConfig) {
        const response = await this.impl.post(requestUrl + url, options.data);
        return this.response(response);
    }

    public response(response: AxiosResponse<any>) {
        if (response.status === 200) return response.data
        else throw new Error()
    }
}

export default makeSingleton(AxiosHttp)();

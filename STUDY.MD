~1カ月に及ぶCorsとの闘い-学習MEMO-

今回の問題は、以下のポイントが絡み合って発生していたようです：

CORS設定の不備

初期設定ではallowedOriginsが正しく設定されていなかったため、フロントエンドからのリクエストがブロックされていました。
明示的にhttp://localhost:3000やhttp://172.28.16.1.nip.io:3000を指定したことで、バックエンドがフロントエンドのリクエストを許可できるようになりました。
Spring Securityの設定

SecurityFilterChainでエンドポイントのアクセス許可が正しく設定されていないと、403 (Forbidden) エラーが発生していました。
特定のエンドポイント（例: /auth/receiveJwt）をpermitAll()で許可したことで、認証なしでアクセスできるようになりました。
CORSとallowCredentialsの関係

allowCredentialsがtrueの場合は、ワイルドカード（*）を使えないことに注意が必要でした。
設定を修正して明示的なオリジンを指定することでエラーを回避できました。
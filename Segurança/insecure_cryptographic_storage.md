# Insecure Cryptographic Storage

*_"É uma vulnerabilidade que ocorre quando as informações não são armazenadas de forma segura."_*  
Fonte: http://www.veracode.com

## Estou vulnerável a falha _Insecure Cryptographic Storage_?

A primeira coisa que você precisa pensar: Quais dados são sensíveis para exigir criptografia?

## Como prevenir a falha _Insecure Cryptographic Storage_

1. Identifique os recursos que precisam ser criptografados
2. Certifique-se de que os backups externos são criptografados
3. Certifique-se de que está usando um algoritmo classificado como seguro
4. Certifique-se de que as senhas possuem um padrão forte
5. Certifique-se de que todas as senhas e as chaves estão protegidas, evitando acesso não autorizado

## Cenário - E-mail corporativo

Nesta estória você tem um cargo de confiança na empresa **T186** e diariamente você recebe e envia mensagens com conteúdo sensível; finanças, parceiros, negócios e estratégia da empresa. Para evitar vazamento de informação, você criptografa a mensagem com a chave pública do destinatário, assim assegurando que somente o destinatário poderá ter acesso ao conteúdo original.

Outras aplicações:

+ Backup
+ Banco de senhas
+ Dados pessoais

## Sniffer

Um `sniffer` é uma ferramenta capaz de análizar pacotes de dados, exemplo são os pacotes do protocolo `TCP` e `UDP`.

### Teste sem implementar criptografia na mensagem

sendMail - bash script

```
#Autor: Enilton Angelim
#Link: https://github.com/eniltonangelim/workshop/blob/master/2%C2%BA%20Workshop%20-%20O%20shell%20imagin%C3%A1rio/bash-hacker.md
function sendMail(){
    host=${1} #smtp server
    port=${2} #port 25 or 587
    ehlo=${3}
    auth=${4}
    user=${5}
    pass=${6}
    mailFrom=${7}
    rcptTo=${8}
    data=${9}
    exec 5<>/dev/tcp/$host/$port
    echo -e "$ehlo" >&5
    sleep 2
    echo -e "$auth" >&5
    sleep 2
    echo -e "$user" >&5
    sleep 1
    echo -e "$pass" >&5
    sleep 1
    echo -e "$mailFrom" >&5
    sleep 1
    echo -e "$rcptTo" >&5
    sleep 1
    echo -e "DATA" >&5
    sleep 1
    echo -e "$data"  >&5
    sleep 1
    echo -e '\r\n.\r\n'  >&5
    sleep 1
    timeout 6 cat <&5
    exec 5>&-
}; export -f sendMail
```

sendMail mail.foobar.com.br 25 "ehlo foobar.com.br\r" "auth login\r" "dGVzdGVAbG9jYWxkb21haW4=\r" "b2JyaWdhZG9zZWFyY2hhbmRyZXBsYWNl
5lc2NlbmNl\r" "mail from:enilton@foobar.com.br\r" "rcpt to:enilton.angelim@gmail.com\r" "Subject:Teste T186\r\rEspero que der certo\r"

```
250-VRFY
250-ENHANCEDSTATUSCODES
250-8BITMIME
250 DSN
334 VXNlcm5hbWU6
334 UGFzc3dvcmQ6
235 2.7.0 Authentication successful
250 2.1.0 Ok
250 2.1.5 Ok
354 End data with <CR><LF>.<CR><LF>
250 2.0.0 Ok: queued as AF6D15743246
500 5.5.2 Error: bad syntax
```

tcpdump -i any -nnn -AAAA -s 0 port 25

```
14:02:35.273805 IP source_ip.39902 > mailserver_ip.25: Flags [S], seq 1346995423, win 29200, options [mss 1452,sackOK,TS val 133521895 ecr 0,nop,wscale 7], length 0
.......#........EH.<.8@./.K..:A...pH....PI........r............
..a.........
14:02:35.273818 IP mailserver_ip.25 > source_ip.39902: Flags [S.], seq 2905881822, ack 1346995424, win 28960, options [mss 1460,sackOK,TS val 4065475528 ecr 133521895,nop,wscale 7], length 0
.......4..?.....E..<..@.@. D..pH.:A......4<.PI....q ...........
.R;...a.....
14:02:35.381562 IP source_ip.39902 > mailserver_ip.25: Flags [.], ack 1, win 229, options [nop,nop,TS val 133521922 ecr 4065475528], length 0
.......#........EH.4.9@./.K..:A...pH....PI...4<.....h......
..b..R;.
14:02:35.381684 IP source_ip.39902 > mailserver_ip.25: Flags [P.], seq 1:18, ack 1, win 229, options [nop,nop,TS val 133521922 ecr 4065475528], length 17
.......#........EH.E.:@./.K..:A...pH....PI...4<......M.....
..b..R;.ehlo foobar.com.br

14:02:35.381692 IP mailserver_ip.25 > source_ip.39902: Flags [.], ack 18, win 227, options [nop,nop,TS val 4065475555 ecr 133521922], length 0
.......4..?.....E..4.<@.@.....pH.:A......4<.PI.............
.R;...b.
14:02:35.399087 IP mailserver_ip.25 > source_ip.39902: Flags [P.], seq 1:45, ack 18, win 227, options [nop,nop,TS val 4065475560 ecr 133521922], length 44
.......4..?.....E..`.=@.@.....pH.:A......4<.PI.............
.R;...b.220 mailservice01.foobar.com.br ESMTP Postfix

14:02:35.506790 IP source_ip.39902 > mailserver_ip.25: Flags [.], ack 45, win 229, options [nop,nop,TS val 133521953 ecr 4065475560], length 0
.......#........EH.4.;@./.K..:A...pH....PI...4=.....g......
..b!.R;.
14:02:35.506800 IP mailserver_ip.25 > source_ip.39902: Flags [P.], seq 45:168, ack 18, win 227, options [nop,nop,TS val 4065475587 ecr 133521953], length 123
.......4..?.....E....>@.@.....pH.:A......4=.PI.............
.R<...b!250-mailservice01.foobar.com.br
250-STARTTLS
250-SIZE 1048576000
250-VRFY
250-ENHANCEDSTATUSCODES
250-8BITMIME
250 DSN

14:02:35.614521 IP source_ip.39902 > mailserver_ip.25: Flags [.], ack 168, win 229, options [nop,nop,TS val 133521980 ecr 4065475587], length 0
.......#........EH.4.<@./.K..:A...pH....PI...4=.....f......
..b<.R<.
14:02:37.384483 IP source_ip.39902 > mailserver_ip.25: Flags [P.], seq 18:30, ack 168, win 229, options [nop,nop,TS val 133522423 ecr 4065475587], length 12
.......#........EH.@.=@./.K..:A...pH....PI...4=............
..c..R<.auth login

14:02:37.421924 IP mailserver_ip.25 > source_ip.39902: Flags [.], ack 30, win 227, options [nop,nop,TS val 4065476066 ecr 133522423], length 0
.......4..?.....E..4.?@.@..^M..pH.:A......4=.PI.............
.R=...c.
14:02:37.435296 IP mailserver_ip.25 > source_ip.39902: Flags [P.], seq 168:186, ack 30, win 227, options [nop,nop,TS val 4065476069 ecr 133522423], length 18
.......4..?.....E..F.@@.@.....pH.:A......4=.PI.............
.R=...c.334 VXNlcm5hbWU6

14:02:37.542978 IP source_ip.39902 > mailserver_ip.25: Flags [.], ack 186, win 229, options [nop,nop,TS val 133522462 ecr 4065476069], length 0
.......#........EH.4.>@./.K..:A...pH....PI...4=.....c   .....
..d..R=.
14:02:39.386780 IP source_ip.39902 > mailserver_ip.25: Flags [P.], seq 30:56, ack 186, win 229, options [nop,nop,TS val 133522923 ecr 4065476069], length 26
.......#........EH.N.?@./.K..:A...pH....PI...4=......Z.....
..e..R=.dGVzdGVAbG9jYWxkb21haW4=

14:02:39.386789 IP mailserver_ip.25 > source_ip.39902: Flags [.], ack 56, win 227, options [nop,nop,TS val 4065476557 ecr 133522923], length 0
.......4..?.....E..4.A@.@.....pH.:A......4=.PI.............
.R?...e.
14:02:39.420656 IP mailserver_ip.25 > source_ip.39902: Flags [P.], seq 186:204, ack 56, win 227, options [nop,nop,TS val 4065476565 ecr 133522923], length 18
.......4..?.....E..F.B@.@.....pH.:A......4=.PI.............
.R?...e.334 UGFzc3dvcmQ6

14:02:39.528288 IP source_ip.39902 > mailserver_ip.25: Flags [.], ack 204, win 229, options [nop,nop,TS val 133522958 ecr 4065476565], length 0
.......#........EH.4.@@./.K..:A...pH....PI...4=.....^......
..f..R?.
14:02:40.387889 IP source_ip.39902 > mailserver_ip.25: Flags [P.], seq 56:94, ack 204, win 229, options [nop,nop,TS val 133523173 ecr 4065476565], length 38
.......#........EH.Z.A@./.K..:A...pH....PI...4=.....FK.....
..f..R?.b2JyaWdhZG9zZWFyY2hhbmRyZXBsYWNl5lc2NlbmNl
:

14:02:40.425912 IP mailserver_ip.25 > source_ip.39902: Flags [.], ack 94, win 227, options [nop,nop,TS val 4065476817 ecr 133523173], length 0
.......4..?.....E..4.C@.@..     ..pH.:A......4=.PI.=...........
.R@...f.
14:02:40.455226 IP mailserver_ip.25 > source_ip.39902: Flags [P.], seq 204:241, ack 94, win 227, options [nop,nop,TS val 4065476824 ecr 133523173], length 37
.......4..?.....E..Y.D@.@.....pH.:A......4=.PI.=...........
.R@...f.235 2.7.0 Authentication successful

14:02:40.562851 IP source_ip.39902 > mailserver_ip.25: Flags [.], ack 241, win 229, options [nop,nop,TS val 133523217 ecr 4065476824], length 0
.......#........EH.4.B@./.K..:A...pH....PI.=.4=.....\......
..g..R@.
14:02:41.389164 IP source_ip.39902 > mailserver_ip.25: Flags [P.], seq 94:124, ack 241, win 229, options [nop,nop,TS val 133523424 ecr 4065476824], length 30
.......#........EH.R.C@./.K..:A...pH....PI.=.4=............
..g..R@.mail from:enilton@foobar.com.br

14:02:41.389180 IP mailserver_ip.25 > source_ip.39902: Flags [.], ack 124, win 227, options [nop,nop,TS val 4065477057 ecr 133523424], length 0
.......4..?.....E..4.E@.@.....pH.:A......4=.PI.[...........
.RA...g.
14:02:41.423395 IP mailserver_ip.25 > source_ip.39902: Flags [P.], seq 241:255, ack 124, win 227, options [nop,nop,TS val 4065477066 ecr 133523424], length 14
.......4..?.....E..B.F@.@.....pH.:A......4=.PI.[...........
.RA...g.250 2.1.0 Ok

14:02:41.531009 IP source_ip.39902 > mailserver_ip.25: Flags [.], ack 255, win 229, options [nop,nop,TS val 133523459 ecr 4065477066], length 0
.......#........EH.4.D@./.K..:A...pH....PI.[.4=.....Z......
..h..RA.
14:02:42.390184 IP source_ip.39902 > mailserver_ip.25: Flags [P.], seq 124:159, ack 255, win 229, options [nop,nop,TS val 133523674 ecr 4065477066], length 35
.......#........EH.W.E@./.K..:A...pH....PI.[.4=............
..h..RA.rcpt to:enilton.angelim@gmail.com

14:02:42.429924 IP mailserver_ip.25 > source_ip.39902: Flags [.], ack 159, win 227, options [nop,nop,TS val 4065477318 ecr 133523674], length 0
.......4..?.....E..4.G@.@.....pH.:A......4=.PI.~...........
.RB...h.
14:02:43.391316 IP source_ip.39902 > mailserver_ip.25: Flags [P.], seq 159:164, ack 255, win 229, options [nop,nop,TS val 133523924 ecr 4065477318], length 5
.......#........EH.9.F@./.K..:A...pH....PI.~.4=............
..i..RB.DATA

14:02:43.391328 IP mailserver_ip.25 > source_ip.39902: Flags [.], ack 164, win 227, options [nop,nop,TS val 4065477558 ecr 133523924], length 0
.......4..?.....E..4.H@.@.....pH.:A......4=.PI.............
.RC...i.
14:02:43.449036 IP mailserver_ip.25 > source_ip.39902: Flags [P.], seq 255:269, ack 164, win 227, options [nop,nop,TS val 4065477572 ecr 133523924], length 14
.......4..?.....E..B.I@.@.....pH.:A......4=.PI.............
.RC...i.250 2.1.5 Ok

14:02:43.556665 IP source_ip.39902 > mailserver_ip.25: Flags [.], ack 269, win 229, options [nop,nop,TS val 133523966 ecr 4065477572], length 0
.......#........EH.4.G@./.K..:A...pH....PI...4=.....Vq.....
..i..RC.
14:02:43.556675 IP mailserver_ip.25 > source_ip.39902: Flags [P.], seq 269:306, ack 164, win 227, options [nop,nop,TS val 4065477599 ecr 133523966], length 37
.......4..?.....E..Y.J@.@.....pH.:A......4=.PI.............
.RC...i.354 End data with <CR><LF>.<CR><LF>

14:02:43.664374 IP source_ip.39902 > mailserver_ip.25: Flags [.], ack 306, win 229, options [nop,nop,TS val 133523992 ecr 4065477599], length 0
.......#........EH.4.H@./.K..:A...pH....PI...4>.....V......
..j..RC.
14:02:44.393173 IP source_ip.39902 > mailserver_ip.25: Flags [P.], seq 164:206, ack 306, win 229, options [nop,nop,TS val 133524175 ecr 4065477599], length 42
.......#........EH.^.I@./.K..:A...pH....PI...4>............
..j..RC.Subject:Teste T186^M^MEspero que der certo

14:02:44
```

O E-mail original

```
...
From: a8@foobar.com.br
To: enilton.angelim@gmail.com
Message-ID: <1580470588.870093.1490203054721.JavaMail.zimbra@foobar.com.br>
Subject: Teste T186
MIME-Version: 1.0
Content-Type: text/plain; charset=utf-8
Content-Transfer-Encoding: 7bit
X-Originating-IP: [173.224.112.72]
X-Mailer: Zimbra 8.0.7_GA_6021 (ZimbraWebClient - FF52 (Linux)/8.0.7_GA_6021)
Thread-Topic: Teste T186
Thread-Index: cyd2d8PnV/B2JR/4QW+skVdAA61fWA==

Espero que der certo
```

### Teste com criptografia

Criando a chave: `gpg --gen-key`

```
gpg: chave 1170B255 marcada como plenamente confiável
chaves pública e privada criadas e assinadas.

gpg: checando o trustdb
gpg: 3 parcial(is) necessária(s), 1 completa(s) necessária(s), modelo de confiança PGP
gpg: profundidade: 0 válidas:   1 assinadas:   0 confiança: 0-, 0q, 0n, 0m, 0f, 1u
gpg: próxima checagem de banco de dados de confiabilidade em 2017-03-23
pub   2048R/1170B255 2017-03-22 [expira: 2017-03-23]
      Impressão digital da chave: FD1F 8E69 22BD 4C0E 686C  69F0 0D37 A800 1170 B255
uid                  Enilton Angelim (Unifor - T186) <enilton.angelim@gmail.com>
sub   2048R/5CDACD29 2017-03-22 [expira: 2017-03-23]
```

Arquivo teste.txt: `echo "Espero que der certo" >/tmp/teste.txt`

Criptografia da mensagem: `gpg --encrypt --sign --armor -r enilton.angelim@gmail.com teste.txt` 

Lendo o arquivo teste.txt.asc: `cat teste.txt.asc`

```
-----BEGIN PGP MESSAGE-----
Version: GnuPG v1

hQEMA8efUztc2s0pAQf8Dr2lGnUHDltkSVaSTIhJRTIu3zyw3QWS4EPJvW1TEbDo
+9e4qdfSl8Lx5mcogN37ZMEUAhNG7EVhjXfB0/daziSw3CmfEqZS6hK5ob3btZZ0
00vcP8XLo2Kw5YfvCwOl8Epfc4BETK4pCFSG8ykLut21ZJbETN3PoYYD/LJIuRSy
lKjPo1LagKtIIWaa/g+aKauIpx0rNFBJQcZDOxQHdT8M/NRxL0z1i2c6nEomi0pO
UWGQu19sKS3gAiDx8CbrQL2CSh7WXNGEShTIsQwV2kRUEKa2owkPFMR8FnggxJVP
EEA+QvCFr+L8/U8Gsl+dj9J1dXJK69c6L6LdV0K2KNLAygEmgd3QhaxpQrQUp2CF
37L73lMzKPciIw2wPFVo728PslBGazu6R/7lad3KdL3pr0BZynGR/2SbA+YbP/Jt
1CX6ZZtWC0Cm1r4QCP+PC5N5j9kXH1bEqK0G0uDYbi951jN8ZmosHCh728QQ7UXl
SBcVZMzoZCVbX2MJSn37W1Yj/64dmiVQIwDvD+8cEjS6SjKa1BxKIWmJH4az4/IY
XxTzkn3fbNmhrcAtBF4DnowE/+bPUdOrZa6adF4zmeJC861/7IF4BL0TdOw8sJUY
U2OO5BWu4TooPeBM+mFmLQ4bsFkVawlwG2Ra3Jzk/f2chyPO/VBHGLwFgu9Ehemq
8Q1iLG7mxNj6LMV+NgvmDsa8w75pYy6cQHA5I4+KnCdpgsAPi/BAs5kvBYZhdOCc
QtFzuBSkIMrgJgN+1k+dHXahBZn4FisoCY7VWGYzMC2BKQyVHNfVZBj+32fy5iJn
I3B/Z5upyibHGHPJndFHk7g+lCUesy2TQ/R4mvJgnnrKmMFoYGbWr9nI6OE=
=WU23
-----END PGP MESSAGE-----
```

### Hash base64

Decifrando o hash

```python
Python 2.7.12 (default, Nov 19 2016, 06:48:10)
[GCC 5.4.0 20160609] on linux2
Type "help", "copyright", "credits" or "license" for more information.
>>> import base64
>>> base64.b64decode(b'dGVzdGVAbG9jYWxkb21haW4=')
'teste@localdomain'
>>> base64.b64decode(b'b2JyaWdhZG9zZWFyY2hhbmRyZXBsYWNl')
'obrigadosearchandreplace'
>>>
```

## Conclusão

*_"Considere o valor comercial dos dados perdidos e o impacto em sua reputação. Qual é a sua responsabilidade legal se esses dados forem expostos? Considere também o dano à sua reputação."_*

Fonte: https://www.owasp.org
-------------------------�� 1.0-----------------------
"��" �Ƃ�:
�� �̓X���b�h�_���v����͂���GUI�c�[���ł��B

�� �͂����� 150 �s�̃R�[�h�łł��Ă��܂��̂ŁA�ƂĂ��M�����������A���������₷���A�܂��J�X�^�}�C�Y���e�Ղł��B

�V�X�e���v��:
WebLogic Server 6.1, 7.0 or 8.1
OS: Java ���T�|�[�g���� Windows �� Unix

�Z�b�g�A�b�v:
1)komuso.zip ��K�؂ȃf�B���N�g���ɉ𓀂���

2)komuso.properties ���ȉ��̂悤�ɕҏW����
JAVA_HOME �� C:\bea81sp2\jrockit81sp2_141_05 �Ȃ� Java�z�[���f�B���N�g����
WL_HOME �� C:\bea81sp2\weblogic81\server �Ȃ� WebLogic �z�[���f�B���N�g����

3)komuso_ja.properties ���ȉ��̂悤�ɕҏW����
java.naming.provider.url �� WebLogic �� URL ��
java.naming.security.principal �� WebLogic �Ǘ��҂̃��[�U����
java.naming.security.credentials �� WebLogic �Ǘ��҂̃p�X���[�h��

�T�^�I�Ȑݒ�ł͈ȉ��̂悤�ɂȂ�܂�
java.naming.provider.url=t3://127.0.0.1:7001
java.naming.security.principal=system
java.naming.security.credentials=weblogic

�����āA�T���v�����O�Ԋu�A�T���v���񐔁A�C�ӂ� MBean �������w�肷�邱�Ƃ��ł��܂��B
�ڂ����� komuso_ja.properties �����Ă��������B

komuso.properties �͎��s���ɏ㏑������܂��B����̓��x���Ƀ}���`�o�C�g���g����悤�ɂ��邽�߂ŁAkomuso_ja.properties �ɑ΂��� native2ascii �������Ă��邩��ł��B
���x���Ƀ}���`�o�C�g�������g���K�v���Ȃ���΁Akomuso.properties, komuso.sh/cmd �������p���������Ă����\�ł��B

�g����:
�R�}���h���C����� komuso_ja.sh/bat �����s����ƁACSV�`���� WebLogic �̏�Ԃ��L�^���܂��B
�o�͐�̃t�@�C�������w�肷�邱�Ƃ��ł��܂��B
- Unix ��(Solaris, Linux, HP-UX, MacOSX, AIX)
$ komuso_ja.sh [filename]
- Windows
> komuso_ja.bat [filename]

�G���[�Ή�:
-java.lang.IllegalArgumentException: mbean not found [heap free:name:type:property]
����� MBean ��������Ȃ��������Ƃ������܂��Bname, type �����������m�F���Ă��������B

-java.lang.IllegalArgumentException: property not found [heap free:name:type:property]
����� MBean �͌����������A�w�肵���v���p�e�B��������Ȃ��������Ƃ������܂��B
�v���p�e�B�����݂��邩�m�F���Ă��������B

-javax.naming.CommunicationException.  Root exception is java.net.ConnectException: t3://localhost:7001: Destination unreachable; nested exception is:
        java.net.ConnectException: Connection refused: connect; No available router to destination
����͎��� WLS �Ԃ̐ڑ�������ꂽ���Ƃ������܂��B
�l�b�g���[�N�ƁAWLS �������Ă��Ȃ����m�F���Ă��������B

�R���p�C��:
�K�v�ɉ����Ď��R�ɃJ�X�^�}�C�Y���邱�Ƃ��ł��܂��B
compile.sh/bat �ŃR���p�C���ł��܂��B

�R�����g���������܂����炨�C�y�ɂǂ����B
�R�{�T��
yusukey@bea.com
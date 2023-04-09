# Tên : Nguyễn Hoàng Thái
# MSSV: 20009931

import pandas as pd
import numpy as np 
import matplotlib.pyplot as plt
import scipy.stats as st
from scipy.stats import norm

data=pd.read_excel('D:\\Thong ke may tinh va ung dung\\DataSet\\03_FRESH15.xls')
print(data)
df=pd.DataFrame(data,columns=['WTSEP','WTAPR','BMISP','BMIAP'])
#can nang thang 9:WTSEP
#can nang thang4:WTAPR
N=df['WTSEP'].count()
print('Tang dong',N)
df_tang=df.query('WTSEP>WTAPR')['WTSEP']
n=df_tang.count()
print(df_tang.count())
print('Ti le la',n/N)
p_mu=n/N
q_mu=1-p_mu
#La gia tri tai do là Z=0.025
#
z_alpha_chia2=(-1)*st.norm.ppf(0.025,0.1)
print('Z_alpha_chia2',z_alpha_chia2)
e=z_alpha_chia2*np.sqrt(p_mu*q_mu/N)
print("Do loi la",e)
print("Khong tin cay la",p_mu-e,p_mu+e)
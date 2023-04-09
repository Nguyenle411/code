# Tên : Nguyễn Hoàng Thái
# MSSV: 20009931

import pandas as pd
import numpy as np 
import matplotlib.pyplot as plt
import scipy.stats as st
from scipy.stats import norm 

#Bai 4
data4=pd.read_excel('D:\\Thong ke may tinh va ung dung\\DataSet\\09_MOVIES.xls')
print(data4)
#N4: tổng số bình chọn
N4 = len(data4['MPAA'])
# Lọc các bình chọn
data_MPAA = data4[['MPAA']]
#Lọc các bình chọn là R
df_R = data_MPAA[data_MPAA['MPAA'] == 'R']
#n_R: tổng các bình chọn là hả R
n_R = len(df_R)
print("Tỉ lệ  tỉ lệ bình chọn là R là {} %".format(n_R/N4))
df_P = data_MPAA[data_MPAA['MPAA'] == 'PG-13']
#n_R: tổng các bình chọn là hả R
n_P = len(df_P)
print("Tỉ lệ  tỉ lệ bình chọn là P là {} %".format(n_P/N4))
p_mu_R = n_R/N4
q_mu_R = 1 - p_mu_R
z_alpha_chia2 = (-1) * st.norm.ppf(0.025,0,1)
#Lỗi
e_R = z_alpha_chia2 * np.sqrt((p_mu_R * q_mu_R)/N4)
print("Khoảng tin cậy là", p_mu_R-e_R,"<= p <=", p_mu_R+e_R)

print('=================================')
data2= pd.read_excel('C:\\Users\\KHC\\Documents\\thống kê máy tính và ứng dụng\\DataSet\\DataSet\\14_BOSTRAIN.xls')
df= pd.DataFrame(data2, columns=['MON','TUES','WED','THURS','FRI','SAT','SUN'])
# x: lượng mưa ngày thứ tư
# c: lượng mưa ngày chủ nhật
# n: kích thước mẫu kẹo có màu bất kì
x= df['WED'].count()
thu4comua= df.query('WED!=0')['WED']
n= thu4comua.count()
print(n)
print(x)
p= n/x
q= 1-p
print('tỉ lệ là lượng mưa ngày thứ 4:', p, '%')
print('q:', q)
z_anpha_chia2= (-1)*st.norm.ppf(.025,0,1)
print("z anpha chia 2: ",z_anpha_chia2)
e= z_anpha_chia2*np.sqrt(p*q/x)
print("lỗi là: ", e)
print("khoảng tin cậy của ngày thứ 4la: ",p-e, p+e)
print('xây dựng ước lượng khoảng in cậy 95% cho tỉ lệ mua ngày chủ nhật')
c= df['SUN'].count()
print(c)
cncomua= df.query('SUN!=0')['SUN']
m=cncomua.count()
print(m)
P= m/c
Q= 1-P
print('tỉ lệ là lượng mưa ngày thứ 4:', P,'%')
print("Q= ",Q)
Z_anpha_chia2= (-1)*st.norm.ppf(.025,0,1)
print("Z anpha chia 2: ",Z_anpha_chia2)
E= Z_anpha_chia2*np.sqrt(P*Q/c)
print("lỗi là: ", E)
print("khoảng tin cậy của ngày cn là: ",P-E, P+E)
'''So sánh : dựa vào kết quả ta thấy tỷ lệ lượng mưa lớn hơn 0 xuất hiện ở các ngày thứ tư 
nhiều hơn so với các ngày chủ nhật nhưng không chênh lệch quá lớn'''